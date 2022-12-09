package controller_presenter;

import entity.*;
import use_case.*;

import java.util.ArrayList;
import java.util.Objects;

public class TileHandler {

    private MovePlayer movePlayer;
    private PlayGamePresenter playGamePresenter;

    private PlayerGoToJailProcessor playerGoToJailProcessor;

    //private UserPayRent userPayRent;

    //private BuyPropertyProcessor buyPropertyProcessor;

    //private UserBuyUtilities userBuyUtilities;

    private DeckDealToPlayer deckDealToPlayer;
    private UserTileInteractor userTileInteractor;
    private ArrayList<Integer> rolls;


    public TileHandler(MovePlayer movePlayer, PlayGamePresenter playGamePresenter, PlayerGoToJailProcessor playerGoToJailProcessor,
                       ArrayList<Integer> rolls,DeckDealToPlayer deckDealToPlayer, UserTileInteractor userTileInteractor){
        this.movePlayer = movePlayer;
        this.playGamePresenter = playGamePresenter;
        this.playerGoToJailProcessor = playerGoToJailProcessor;
        //this.userPayRent = userPayRent;
        //this.buyPropertyProcessor = buyPropertyProcessor;
        this.deckDealToPlayer = deckDealToPlayer;
        //this.userBuyUtilities = userBuyUtilities;
        this.rolls = rolls;
        this.userTileInteractor = userTileInteractor;
    }
    public Object HandleTile(Object tile) {
        if (tile instanceof String) {
            // may be simple factory design pattern
            if (tile == "Income Tax"){
                String message = this.movePlayer.taxPlayer(200);
                if (Objects.equals(message, "Success")){
                    this.playGamePresenter.TaxPlayer(200);
                    return null;
                }
                if (Objects.equals(message, "Bankrupt")){
                    this.playGamePresenter.Bankrupt();
                    return "Bankrupt";
                }
                else{
                    this.playGamePresenter.Mortgage(message);
                    return null;
                }

            }
            else if (tile == "Luxury Tax") {
                String message = this.movePlayer.taxPlayer(100);
                if (Objects.equals(message, "Success")){
                    this.playGamePresenter.TaxPlayer(100);
                    return null;}
                if (Objects.equals(message, "Bankrupt")){
                    this.playGamePresenter.Bankrupt();
                    return "Bankrupt";
                }
                else{
                    this.playGamePresenter.Mortgage(message);
                    return null;
                }
            }

            else if (tile == "Go to Jail") {
                this.playerGoToJailProcessor.PlayerGoToJail();
                this.playGamePresenter.PlayerGoToJail();
                return null;
            }

            else if (tile == "Chance Card"){
                String message = this.deckDealToPlayer.DealChanceCard();
                if (Objects.equals(message, "Free card")){
                    this.playGamePresenter.getOutofJailFreeCard();
                }
                else{
                    //this.playerGoToJailProcessor.PlayerGoToJail();
                    this.playGamePresenter.PlayerGoToJail();
                }
                return null;
            }
            else{
                String message = this.deckDealToPlayer.DealCommunityCard();
                if (Objects.equals(message, "Go")){
                    this.playGamePresenter.CommunityCardPresenter("Advance to Go. (Collect $200)");
                    return null;
                }
                else if (Objects.equals(message, "Collect")){
                    this.playGamePresenter.CommunityCardPresenter("Bank error in your favor. Collect $200.");
                    return null;
                }
                else if (Objects.equals(message, "Bankrupt")){
                    this.playGamePresenter.Bankrupt();
                    return message;
                }
                else if (Objects.equals(message, "Doctor")){
                    this.playGamePresenter.CommunityCardPresenter("Doctor's fees. {fee} Pay $50.");
                    return null;
                }
                else if (Objects.equals(message, "Free card")){
                    this.playGamePresenter.getOutofJailFreeCard();
                    return null;
                }
                else{
                    this.playerGoToJailProcessor.PlayerGoToJail();
                    this.playGamePresenter.PlayerGoToJail();
                    return null;
                }

            }
        }
        else if(tile instanceof TileCanBuy) {
            if (Objects.equals(this.movePlayer.getPropertyOwner((TileCanBuy) tile),null)){
                // call UI and wait UI to pass true or false.
                ArrayList<Object> buy = new ArrayList<>(1);
                buy.add(null);
                this.playGamePresenter.BuyProperty(buy, this.userTileInteractor.getName());
                while (buy.get(0) == null){
                    System.out.println("");
                }

                if (Objects.equals(buy.get(0), true)){
                    String message = this.userTileInteractor.buy();
                    if (Objects.equals(message, "Success")){
                        this.playGamePresenter.BuyPropertySuccessful(this.userTileInteractor.getName());
                    }
                    else{
                        this.playGamePresenter.NotEnoughMoney();
                    }
                }
                return null;
            }
            else{
                String message = this.userTileInteractor.payRent(this.rolls);
                if (Objects.equals(message, "Bankrupt")) {
                    this.playGamePresenter.Bankrupt();
                    return "Bankrupt";
                }
                if (message.contains("Paid Rent to")){
                    this.playGamePresenter.payRent(this.userTileInteractor.getRent(rolls), userTileInteractor.getName(), false, null);
                }
                else {
                    this.playGamePresenter.payRent(this.userTileInteractor.getRent(rolls), userTileInteractor.getName(), true, message);
                    this.playGamePresenter.Mortgage(message);
                }
                return null;
            }
        }
        return null;

    }


}

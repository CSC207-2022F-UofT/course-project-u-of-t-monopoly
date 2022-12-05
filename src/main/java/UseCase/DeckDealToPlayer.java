package UseCase;

import Entity.*;
import com.jogamp.common.util.JogampVersion;

import java.util.Objects;

public class DeckDealToPlayer {

    private Deck deck;
    private Player player;

    private GameBoard gameBoard;

    public DeckDealToPlayer(Player player, GameBoard gameBoard){
        this.deck = new Deck();
        this.player = player;
        this.gameBoard = gameBoard;
    }

    public String DealChanceCard(){
        ChanceCard card = (ChanceCard) this.deck.getCard("chance");
        if (Objects.equals(card.getCard(), "Get Out of Jail Free.")){
            this.player.addOutOfJailFreeCard();
            this.deck.updateDeck("chance");
            return "Free card";
        }
        else{
            PlayerGoToJailProcessor processor = new PlayerGoToJailProcessor(this.player, this.gameBoard);
            processor.PlayerGoToJail();
            return "Jail";
        }
    }

    public String DealCommunityCard(){
        CommunityCard card = (CommunityCard) this.deck.getCard("community");
        if (Objects.equals(card.getCard(), "Advance to \"Go\". (Collect $200)")){
            this.player.addMoney(200);
            this.player.setPlayerPosition(0);
            return "Go";
        }
        else if (Objects.equals(card.getCard(), "Bank error in your favor. Collect $200.")){
            this.player.addMoney(200);
            return "Collect";
        }
        else if(Objects.equals(card.getCard(), "Doctor's fees. {fee} Pay $50.")) {
            this.player.loseMoney(50);
            if(this.player.checkBankruptcy()){
                return "Bankrupt";
            }
            else{
                return "Doctor";
            }
        }
        else if(Objects.equals(card.getCard(), "Get Out of Jail Free.")){
            this.player.addOutOfJailFreeCard();
            this.deck.updateDeck("community");
            return "Free card";
        }
        else{
            PlayerGoToJailProcessor processor = new PlayerGoToJailProcessor(this.player, this.gameBoard);
            processor.PlayerGoToJail();
            return "Jail";
        }
    }

}

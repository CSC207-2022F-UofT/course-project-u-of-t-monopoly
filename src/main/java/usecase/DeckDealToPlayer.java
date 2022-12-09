package usecase;

import entity.*;


import java.util.Objects;

/**
 * A class in charge of dealing either a chance card or a community card to a player, based off
 * a given Deck object
 */
public class DeckDealToPlayer {

    private Deck deck;
    private Player player;

    private GameBoard gameBoard;

    /**
     * Instantiate a DeckDealToPlayer object based on the inputted Player object and the GameBoard object
     * @param player the player to be dealt a card
     * @param gameBoard the overall GameBoard (state of game)
     */
    public DeckDealToPlayer(Player player, GameBoard gameBoard){
        this.deck = new Deck();
        this.player = player;
        this.gameBoard = gameBoard;
    }

    /**
     * Deal a chance card to a player associated with this use case object DeckDealToPlayer
     * @return a String representing the deck dealt to the Player
     */
    public String dealChanceCard(){
        ChanceCard card = (ChanceCard) this.deck.getCard("chance");
        if (Objects.equals(card.getCard(), "Get Out of Jail Free.")){
            this.player.addOutOfJailFreeCard();
            this.deck.updateDeck("chance");
            return "Free card";
        }
        else{
            PlayerGoToJailProcessor processor = new PlayerGoToJailProcessor(this.player, this.gameBoard);
            processor.playerGoToJail();
            return "Jail";
        }
    }

    /**
     * Deal a community card to the player
     * @return the String representing the card that was dealt 
     */
    public String dealCommunityCard(){
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
            processor.playerGoToJail();
            return "Jail";
        }
    }

}

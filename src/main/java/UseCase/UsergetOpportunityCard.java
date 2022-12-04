package UseCase;

import Entity.*;

import java.util.Objects;

public class UsergetOpportunityCard {

    Player player;
    Deck deck;
    OpportunityCard  card;
    String cardtype;

    /**
     * Construck a new getopportunitycard class
     * @param player The player who are going to draw the card.
     * @param deck the deck includes all opportunity card.
     */
    public UsergetOpportunityCard(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
        this.card = null;
    }

    /**
     * Draw a chance card from deck and return its name.
     * @return the name of the chance card.
     */
    public String drawChanceCard() {
        ChanceCard card = (ChanceCard) this.deck.getCard("chance");
        this.card = card;
        this.cardtype = "chance";
        return card.getCard();
    }

    /**
     * Draw a community card from deck and return its name.
     * @return the name of the community card.
     */
    public String drawCommunityCard() {
        CommunityCard card = (CommunityCard) this.deck.getCard("community");
        this.card = card;
        this.cardtype = "community";
        return card.getCard();
    }

    /**
     * Player will move or get/loss money corresponding to the card.
     * If the card is get out of jail free, the player can keep it.
     */
    public void playeract() {
        this.player.movePlayer(this.player, this.card.getMovement());
        this.player.addMoney(this.card.getMoneychange());
        if (Objects.equals(this.card.getCard(), "Get Out of Jail Free.")) {
            this.player.addOutOfJailFreeCard();
            this.deck.updateDeck(this.cardtype);
        }
    }
}

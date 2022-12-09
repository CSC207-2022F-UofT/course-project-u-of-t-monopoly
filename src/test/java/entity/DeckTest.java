package entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class DeckTest {
    // Please run tests in build.gradle
    @Test
    public void testDeckGetCard1(){
        Deck deck = new Deck();
        ArrayList<String> lstCom = new ArrayList<>();
        lstCom.add("Advance to \"Go\". (Collect $200)");
        lstCom.add("Bank error in your favor. Collect $200.");
        lstCom.add("Doctor's fees. {fee} Pay $50.");
        lstCom.add("Get Out of Jail Free.");
        lstCom.add("Go to Jail.");
        for (int i = 0; i < 10 ; i++){
            String c = deck.getCard("community").getCard();
            Assertions.assertTrue(lstCom.contains(c));
        }
    }

    @Test
    public void testDeckGetCard2() {
        Deck deck = new Deck();
        ArrayList<String> lstCh = new ArrayList<>();
        lstCh.add("Get Out of Jail Free.");
        lstCh.add("Go to Jail.");
        for (int i = 0; i < 10; i++) {
            String c = deck.getCard("chance").getCard();
            Assertions.assertTrue(lstCh.contains(c));
        }
    }

    @Test
    public void testDeckUpdate(){
        Deck deck = new Deck();
        Assertions.assertTrue(deck.updateDeck("community"));
        Assertions.assertTrue(deck.updateDeck("chance"));
        Assertions.assertFalse(deck.updateDeck("community"));
        Assertions.assertFalse(deck.updateDeck("chance"));

    }
}


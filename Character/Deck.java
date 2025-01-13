package Characters;

import Card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<>();

    private int counter; // Used to track current "top" card in the deck

    public Deck() {
        // Creates each card by suit then rank
        for(int i = 0; i < 52; i++) {
            deck.add(new Card(Suit.fromInt(i / 13), Rank.fromInt(i % 13)));
        }

        //TODO remove after testing/showcasing
        for (Card c : deck) {
            System.out.println(c);
        }

        counter = 0;
    }

    public void shuffle() {
        Collections.shuffle(deck); // shuffle deck using built in List shuffle function
        counter = 0; // reset top card counter to the "top" of the deck

        //TODO remove after testing/showcasing
        for (Card c : deck) {
            System.out.println(c);
        }
    }

    public Card drawCard() {
        Card drawnCard; // holds return card

        if (counter < 52) {
            drawnCard = deck.get(counter);
            counter++;
        }
        else { // If the last card is pulled (should never happen in blackjack), shuffle and restart
            counter = 0;
            shuffle();
            drawnCard = deck.get(counter);
        }

        return drawnCard;
    }
}

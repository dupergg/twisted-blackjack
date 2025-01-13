package Characters;

import Card.Card;


public class Dealer extends Character {
    // For Reference:
    //  Inherits Variables - hand, handTotal
    //  Inherits Methods - resetHand, initializeHand, hit, calculateHandTotal
    private Deck deck;

    public Dealer() {
        deck = new Deck();
    }

    public void shuffle() {
        deck.shuffle();
    }

    public Card drawCard() {
        return deck.drawCard();
    }

    @Override
    public void initializeHand() { // primitive, yet effective
        hand.add(this.drawCard());
        hand.add(this.drawCard());
    }

    @Override
    public void hit() {
        hand.add(this.drawCard());
    }
}

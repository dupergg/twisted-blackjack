package Characters;

import Card.*;

import java.util.List;
import java.util.ArrayList;

// Abstract class used as a foundation for Characters.Dealer and Characters.Player, aka "characters" in the game
abstract class Character {
    // List of cards to represent the Character's hand
    public List<Card> hand = new ArrayList<>();

    // Tracks the integer equivalent total for the Character's hand
    public int handTotal; // integer with hand total

    abstract public void initializeHand(); // draw 2 cards to "initialize" the hand
    abstract public void hit(); // draw a card from the dealer deck

    public void resetHand() {
        hand.clear();
    }
    
        // Ace Check for Over 21
        // Card is a Comparable
    public int calculateHandTotal() {
        Collections.sort(hand);
        handTotal = 0;

        for (Card card : hand) {
            if (card.getRank() == Rank.ACE && handTotal+11 > 21) {
                handTotal +=1;
            }
            else {
                handTotal += card.getRankValue();
            }
        }
        return handTotal; // for an easy return if needed
    }
}

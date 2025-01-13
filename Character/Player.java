package Character;

public class Player extends Character {
    // For Reference:
    //  Inherits Variables - hand, handTotal
    //  Inherits Methods - resetHand, initializeHand, hit, calculateHandTotal
    public String name;
    private int health;
    private int bet;

    Dealer dealer; // Tracks dealer object used for deck handling

    public Player(String name, Dealer dealer) {
        this.name = name;
        this.dealer = dealer;
    }

    public int getHealth() { return health; }

    public int getBet() { return bet; }

    public void setBet(int bet) {
        this.bet = bet;
    }

    // Used for healing or damage - make sure to modify by negative number for damage
    public void modifyHealth(int amount) {
        health = health + amount;
    }

    @Override
    public void initializeHand() { // primitive, yet effective
        hand.add(dealer.drawCard());
        hand.add(dealer.drawCard());
    }

    @Override
    public void hit() {
        hand.add(dealer.drawCard());
    }

}

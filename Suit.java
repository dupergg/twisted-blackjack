public enum Suit {
    CLUB("Clubs"),
    HEART("Hearts"),
    DIAMOND("Diamonds"),
    SPADE("Spades"),
    JOKER("Joker");

    String suitName;

    Suit(String name) {
        suitName = name;
    }

    public String toString() {
        return suitName;
    }

    // Method used to derive a card suit from an integer
    //      Used for generating deck in Characters.Deck class
    public static Suit fromInt(int x) {
        switch(x) {
            case 0:
                return CLUB;
            case 1:
                return SPADE;
            case 2:
                return HEART;
            case 3:
                return DIAMOND;
            default: // default will return sentinel value
                return JOKER;
        }
    }
}
public enum Rank {
    ACE("Ace", 11),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10),
    JOKER("Joker", -1);

    public String rankName;
    public int rankValue;
    Rank(String name, int value) {
        rankName = name;
        rankValue = value;
    }

    public String toString() {
        return rankName;
    }

    // Method used to derive a card rank from an integer
    //      Used for generating deck in Characters.Deck class
    public static Rank fromInt(int x) {
        switch (x) {
            case 0:
                return ACE;
            case 1:
                return TWO;
            case 2:
                return THREE;
            case 3:
                return FOUR;
            case 4:
                return FIVE;
            case 5:
                return SIX;
            case 6:
                return SEVEN;
            case 7:
                return EIGHT;
            case 8:
                return NINE;
            case 9:
                return TEN;
            case 10:
                return JACK;
            case 11:
                return QUEEN;
            case 12:
                return KING;
            default: // will return sentinel value JOKER
                return JOKER;
        }
    }
}
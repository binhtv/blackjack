package card;

public enum RankCard {
    ACE(1, false), TWO(2, false), THREE(3, false),
    FOUR(4, false), FIVE(5, false), SIX(6, false),
    SEVEN(7, false), EIGHT(8, false), NINE(9, false),
    TEN(10, false),
    JACK(10, true), QUEEN(10, true), KING(10, true);

    RankCard(int value, boolean isFaced) {
        this.value = value;
        this.isFaced = isFaced;
    }

    private int value;
    private boolean isFaced;

    public int getValue() {
        return value;
    }

    public boolean isFaced() {
        return isFaced;
    }

    public int getEleven() {
        if (this != ACE) {
            return getValue();
        }

        return 11;
    }
}

package card;

import java.util.Objects;

public class Card {
    private SuitCard suit;
    private RankCard rank;

    Card(SuitCard suit, RankCard rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public SuitCard getSuit() {
        return suit;
    }

    public RankCard getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}

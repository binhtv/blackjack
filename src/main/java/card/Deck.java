package card;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new LinkedList<>();
        for(SuitCard suit : SuitCard.values()) {
            for(RankCard rank : RankCard.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if(cards.isEmpty()) {
            return null;
        }

        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public String toString() {
        return "card.Deck{" +
                "cards=" + cards +
                '}';
    }
}

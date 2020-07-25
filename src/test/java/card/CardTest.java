package card;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void testCreateCard() {
        Card card = new Card(SuitCard.CLUBS, RankCard.ACE);

        Assert.assertNotNull("Card should not be null", card);
        Assert.assertEquals("Card suit should be equals", card.getSuit(), SuitCard.CLUBS);
        Assert.assertEquals("Card rank should be equals", card.getRank(), RankCard.ACE);
    }
}

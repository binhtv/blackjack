package card;

import org.junit.Test;
import player.BlackJackPlayer;
import player.Dealer;

public class BlackJackTest {
    @Test
    public void test() throws Exception {
        Deck deck = new Deck();
        deck.shuffle();

        Dealer dealer = new Dealer();
        dealer.hit(new Card(SuitCard.HEARTS, RankCard.QUEEN));
        dealer.hit(new Card(SuitCard.HEARTS, RankCard.SIX));
        BlackJackPlayer player = new BlackJackPlayer();
        player.hit(new Card(SuitCard.HEARTS, RankCard.TEN));
        player.hit(new Card(SuitCard.HEARTS, RankCard.THREE));
        player.hit(new Card(SuitCard.HEARTS, RankCard.JACK));

        System.out.println(dealer.getScore());
        System.out.println(player.getScore());
    }
}

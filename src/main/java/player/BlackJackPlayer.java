package player;

import java.util.Arrays;

public class BlackJackPlayer extends Player {
    @Override
    public String toString() {
        return "BlackJackPlayer{" +
                "numberOfCard=" + numberOfCard +
                ", cards=" + Arrays.toString(cards) +
                '}';
    }
}

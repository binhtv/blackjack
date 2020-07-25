package player;

import common.Action;

import java.util.Arrays;

public class Dealer extends Player {
    private static final int hiddenIndex = 0;

    public void showHiddenCard() {
        System.out.println(String.format("Dealer hidden card: %s", cards[hiddenIndex]));
    }

    public void check() {
        this.action = Action.CHECK;
    }

    public boolean checked() {
        return action == Action.CHECK;
    }

    @Override
    public boolean isOver() {
        return super.isOver() || checked();
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "numberOfCard=" + numberOfCard +
                ", cards=" + Arrays.toString(cards) +
                '}';
    }
}

package player;

import card.Card;
import card.RankCard;
import common.Action;
import common.Constants;
import exception.BackJackException;
import exception.DuplicateCardsException;
import exception.ExceededNumOfCardsException;

public class Player {
    private static final int MAX_COUNT = 5;
    private static final int MAX_SCORE = 21;
    private static final int MIN_SCORE = 16;
    protected int numberOfCard = 0;
    protected Card[] cards;
    protected Action action;

    public Player() {
        this.cards = new Card[MAX_COUNT];
    }

    private boolean exist(Card card) {
        for (int i = 0; i < numberOfCard; i++) {
            if (card.equals(cards[i])) {
                return true;
            }
        }

        return false;
    }

    public void hit(Card card) throws BackJackException {
        if (card == null) {
            throw new BackJackException(String.format("The card must not be null"));
        }

        if (numberOfCard == MAX_COUNT) {
            throw new ExceededNumOfCardsException(String.format("The maximum number of card is ", MAX_COUNT));
        }

        if (exist(card)) {
            throw new DuplicateCardsException(String.format("Card: %s already exists", card));
        }

        this.cards[numberOfCard++] = card;
        this.action = Action.HIT;
    }

    public void stands() {
        this.action = Action.STAND;
    }

    private int getNguLinh() {
        if (numberOfCard != MAX_COUNT) {
            return 0;
        }

        int score = 0;
        for (int i = 0; i < numberOfCard; i++) {
            score += cards[i].getRank().getValue();
        }

        if (score <= MAX_SCORE) {
            return Constants.NGU_LINH_SCORE - score;
        }

        return 0;
    }

    private int getXiBan() {
        if (numberOfCard == 2 && (cards[0].getRank().getValue() + cards[1].getRank().getValue()) == 2) {
            return Constants.XI_BAN_SCORE;
        }

        return 0;
    }

    private int getXiDzach() {
        if (numberOfCard != 2) {
            return 0;
        }

        if ((cards[0].getRank() == RankCard.ACE && cards[1].getRank().isFaced()) ||
                (cards[1].getRank() == RankCard.ACE && cards[0].getRank().isFaced())) {
            return Constants.XI_DZACH_SCORE;
        }

        return 0;
    }

    public boolean isOver() {
        return numberOfCard == MAX_COUNT ||
                action == Action.STAND;
    }

    private int calculateScore() {
        int score = 0;
        int numOfAce = 0;
        for (int i = 0; i < numberOfCard; i++) {
            if (cards[i].getRank() == RankCard.ACE) {
                numOfAce++;
            } else {
                score += cards[i].getRank().getValue();
            }
        }
        if (numOfAce == 1 && score <= 10) {
            score += RankCard.ACE.getEleven();
        } else {
            score += (numOfAce * RankCard.ACE.getValue());
        }

        if(score < MIN_SCORE) {
            return Constants.SMALL_SCORE + score;
        }

        if(score > MAX_SCORE) {
            return -score;
        }

        return score;
    }

    public int getScore() {
        int nguLinh = getNguLinh();
        if(nguLinh != 0) {
            return nguLinh;
        }

        return getXiBan() + getXiDzach() + calculateScore();
    }
}

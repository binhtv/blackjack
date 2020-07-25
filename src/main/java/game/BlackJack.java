package game;

import card.Deck;
import common.Action;
import exception.BackJackException;
import player.BlackJackPlayer;
import player.Dealer;
import player.Player;

import java.util.Scanner;

public class BlackJack {
    private Deck deck;
    private Dealer dealer;
    private BlackJackPlayer player;

    public void newGame() throws BackJackException {
        deck = new Deck();
        deck.shuffle();

        dealer = new Dealer();
        player = new BlackJackPlayer();

        dealer.hit(deck.draw());
        player.hit(deck.draw());
        dealer.hit(deck.draw());
        player.hit(deck.draw());
    }

    private Player whoWins() {
        int diff = dealer.getScore() - player.getScore();
        return diff == 0 ? null : (diff > 0 ? dealer : player);
    }

    private Action receiveAction(Scanner scanner) {
        Action action;
        try {
            action = Action.of(scanner.nextInt());
        } catch (Exception e) {
            //log
            scanner.nextLine();
            action = null;
        }

        return action;
    }

    public void information() {
        System.out.println("*****Welcome to BlackJack*****");
        System.out.println("Input hit: 1, stand: 2, check: 3");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        dealer.showHiddenCard();
        try {
            while (!player.isOver() && !deck.isEmpty()) {
                System.out.print("Player input: ");
                Action playerAct = receiveAction(scanner);
                if (playerAct == null || playerAct == Action.CHECK) {
                    System.out.println("Invalid action");
                    continue;
                }

                switch (playerAct) {
                    case STAND:
                        player.stands();
                        break;
                    case HIT:
                        player.hit(deck.draw());
                        break;
                }
            }

            while (!dealer.isOver() && !deck.isEmpty()) {
                System.out.print("Dealer input: ");
                Action dealerAct = receiveAction(scanner);
                if (dealerAct == null) {
                    System.out.println("Invalid action");
                    continue;
                }

                switch (dealerAct) {
                    case STAND:
                        dealer.stands();
                        break;
                    case HIT:
                        dealer.hit(deck.draw());
                        break;
                    case CHECK:
                        dealer.check();
                        break;

                }
            }
        } catch (BackJackException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("Dealer: %s", dealer));
        System.out.println(String.format("Player: %s", player));
        System.out.println(String.format("Winner: %s", whoWins()));
    }
}

import game.BlackJack;

import java.util.Scanner;

public class Application {
    public static void main(String... strings) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BlackJack blackJack = new BlackJack();
        blackJack.information();
        while (true) {
            blackJack.newGame();
            blackJack.run();
            System.out.print("More Y/N? ");
            if(!"y".equalsIgnoreCase(scanner.nextLine())) {
                System.out.println("Bye!");
                break;
            }
        }
        scanner.close();
    }
}

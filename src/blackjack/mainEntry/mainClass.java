package blackjack.mainEntry;

import blackjack.controller.GameController;
import blackjack.controller.IPlayer;
import blackjack.player.ComputerDealer;
import blackjack.player.HumanDealer;
import blackjack.player.HumanPlayer;

public class mainClass {

    public static void main(String[] args) {
        realOneGame1();
        System.out.println();
        realOneGame2();
    }

    private static void realOneGame1() {

        HumanPlayer player1 = new HumanPlayer("Human player #1", 10);
        HumanPlayer player2 = new HumanPlayer("Human player #2", 10);
        player1.printPlaceBet();
        player2.printPlaceBet();
        IPlayer[] players = new IPlayer[]{player1, player2};

        CardProvider cardProvider = new CardProvider(new int[]{3, 9, 9, 2, 5, 6}, 2);

        // for implementing Human dealer
        GameController controller = new GameController(new GamePolicy(), cardProvider, new HumanDealer("Human Dealer"), players);
        controller.run();
    }

    private static void realOneGame2() {

        HumanPlayer player1 = new HumanPlayer("Human player #1", 10);
        HumanPlayer player2 = new HumanPlayer("Human player #2", 10);
        player1.printPlaceBet();
        player2.printPlaceBet();
        IPlayer[] players = new IPlayer[]{player1, player2};

        CardProvider cardProvider = new CardProvider(new int[]{3, 9, 9, 2, 5, 6}, 2);

        // for implementing Computer dealer
        GameController controller = new GameController(new GamePolicy(), cardProvider, new ComputerDealer("Computer Dealer"), players);
        controller.run();
    }
}

package blackjack.mainEntry;

import blackjack.controller.GameController;
import blackjack.controller.IPlayer;
import blackjack.player.Dealer;
import blackjack.player.realPlayer;

public class mainClass {

    public static void main(String[] args) {
        realOneGame1();
        System.out.println();
        //realOneGame2();
    }

    private static void realOneGame1() {

        realPlayer player1 = new realPlayer("Human player #1", 10);
        realPlayer player2 = new realPlayer("Human player #2", 10);
        player1.printPlaceBet();
        player2.printPlaceBet();
        IPlayer[] players = new IPlayer[]{player1, player2};

        CardProvider cardProvider = new CardProvider(new int[]{3, 9, 9, 2, 5, 6}, 3);

        // for implementing Human dealer
        GameController controller = new GameController(new GamePolicy(), cardProvider, new Dealer("Human Dealer"), players);
        controller.run();
    }

    private static void realOneGame2() {

        realPlayer player1 = new realPlayer("Human player #1", 10);
        realPlayer player2 = new realPlayer("Human player #2", 10);
        player1.printPlaceBet();
        player2.printPlaceBet();
        IPlayer[] players = new IPlayer[]{player1, player2};

        CardProvider cardProvider = new CardProvider(new int[]{3, 9, 9, 2, 5, 6}, 3);

        // for implementing Computer dealer
        GameController controller = new GameController(new GamePolicy(), cardProvider, new Dealer("Computer Dealer"), players);
        controller.run();
    }
}

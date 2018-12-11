package blackjack.mainEntry;

import blackjack.controller.GameController;
import blackjack.controller.IPlayer;

public class mainDummy {
    public static void main(String[] args) {
        simpleDummyOneGame();
        System.out.println("It works");
    }

    private static void simpleDummyOneGame() {
        IPlayer[] players = new IPlayer[]{new Player("#1"), new Player("#2")};
        CardProvider cardProvider = new CardProvider(
                new int[]{},
                2
        );
        GameController controller = new GameController(
                new GamePolicy(), cardProvider, new Player("Dealer"), players
        );
        controller.run();

    }
}

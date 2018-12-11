package blackjack.mainEntry;

import blackjack.controller.GameController;
import blackjack.controller.IPlayer;
import blackjack.player.HumanDealer;
import blackjack.player.HumanPlayer;

public class mainDummy {
    public static void main(String[] args) {
        simpleDummyOneGame();
        System.out.println("It works");
    }

    private static void simpleDummyOneGame() {
        IPlayer[] players = new IPlayer[]{new HumanPlayer("#1"), new HumanPlayer("#2")};
        CardProvider cardProvider = new CardProvider(
                new int[]{},
                2);
        GameController controller = new GameController(
                new GamePolicy(), cardProvider, new HumanDealer("Dealer"), players);
        controller.run();
    }
}

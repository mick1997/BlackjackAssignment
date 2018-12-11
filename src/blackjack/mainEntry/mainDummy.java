package blackjack.mainEntry;

import blackjack.controller.GameController;
import blackjack.controller.IPlayer;
import blackjack.player.ComputerDealer;
import blackjack.player.HumanDealer;
import blackjack.player.HumanPlayer;

public class mainDummy {

    public static void main(String[] args) {
        simpleDummyOneGame();
        System.out.println("It works");
    }

    private static void simpleDummyOneGame() {
        IPlayer[] players = new IPlayer[]{new HumanPlayer("Human player #1"), new HumanPlayer("Human player #2")};
        CardProvider cardProvider = new CardProvider(
                new int[]{1, 2, 3, 4, 5, 6},
                2);
        GameController controller = new GameController(
                new GamePolicy(), cardProvider, new ComputerDealer("Computer Dealer"), players);
        controller.run();
    }

//    private static void realOneGame() {
//        Deck[] decks = new Deck[]{};
//        IPlayer[] players = new IPlayer[]{new HumanPlayer("Human Player #1"), new HumanPlayer("Human player #2")};
//        CardProvider cardProvider = new CardProvider(decks, 2);
//    }
}

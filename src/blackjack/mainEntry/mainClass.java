package blackjack.mainEntry;

import blackjack.card.Deck;
import blackjack.controller.GameController;
import blackjack.controller.ICardProvider;
import blackjack.controller.IPlayer;
import blackjack.player.Dealer;
import blackjack.player.RealPlayer;

public class mainClass {

    public static void main(String[] args) {
        realOneGame1();
        System.out.println();
        //realOneGame2();
    }

    private static void realOneGame1() {

        IPlayer player1 = new RealPlayer("Human player #1", 10);
        IPlayer player2 = new RealPlayer("Human player #2", 10);
        IPlayer[] players = new IPlayer[]{player1, player2};

        ICardProvider deckProvider = new Deck(52);  // Creator logic, irrelevant to others.


        // for implementing Human dealer
        GameController controller = new GameController(new GamePolicy(), deckProvider, new Dealer("Human Dealer"), players);
        controller.run();
    }

    private static void realOneGame2() {

        IPlayer player1 = new RealPlayer("Human player #1", 10);
        IPlayer player2 = new RealPlayer("Human player #2", 10);
        IPlayer[] players = new IPlayer[]{player1, player2};

        ICardProvider deckProvider = new Deck(2);

        // for implementing Computer dealer
        GameController controller = new GameController(new GamePolicy(), deckProvider, new Dealer("Computer Dealer"), players);
        controller.run();
    }
}

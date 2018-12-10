package blackjack.mainEntry;

import blackjack.card.Card;
import blackjack.controller.GameController;
import blackjack.controller.ICardProvider;
import blackjack.controller.IGamePolicy;
import blackjack.controller.IPlayer;

import java.util.Arrays;

class DummyGamePolicy implements IGamePolicy {

    @Override
    public boolean isPlayerWin(IPlayer dealer, IPlayer player) {
        return false;
    }
}

class DummyCardProvider implements ICardProvider {

    int howManyCreated = 0;
    Card[] initialCards = createCards(new int[]{10, 8, 5, 3, 4, 6});

    static Card[] createCards(int[] values) {
        Card[] cards = new Card[values.length];
        for (int i = 0; i < values.length; i++) {
            cards[i] = new Card(values[i]);
        }
        return cards;
    }

    @Override
    public Card[] getNext(int count) {
        if (howManyCreated < 6){
            Card[] out = new Card[count];
            for (int i = 0; i < out.length; i++) {
                out[i] = initialCards[howManyCreated+i];
            }
            howManyCreated += count;
            return out;
        }
        return createCards(new int[]{1});
    }
}

class DummyPlayer implements IPlayer {

    private String name;

    public DummyPlayer(String name){
        this.name = name;
    }

    @Override
    public void acceptCards(Card[] newCards) {
        System.out.println(String.format("Player %s accept cards: %s", name, Arrays.toString(newCards)));
    }

    @Override
    public void think() {
        System.out.println(String.format("Player %s thinking", name));
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public boolean isBlackJack() {
        return false;
    }

    @Override
    public boolean isBusted() {
        return false;
    }

    @Override
    public void addCredit(int amount) {

    }

    @Override
    public int getBet() {
        return 0;
    }
}




public class mainDummy {
    public static void main(String[] args) {
        simpleDummyOneGame();
        System.out.println("It works");
    }

    static void simpleDummyOneGame() {
        IPlayer[] players = new IPlayer[]{new DummyPlayer("#1"), new DummyPlayer("#2")};
        GameController controller = new GameController(
                new DummyGamePolicy(), new DummyCardProvider(), new DummyPlayer("Dealer"), players
        );
        controller.run();

    }
}

package blackjack.mainEntry;

import blackjack.card.Card;
import blackjack.controller.GameController;
import blackjack.controller.ICardProvider;
import blackjack.controller.IGamePolicy;
import blackjack.controller.IPlayer;

import java.util.ArrayList;
import java.util.Arrays;

class DummyGamePolicy implements IGamePolicy {

    @Override
    public boolean isPlayerWin(IPlayer dealer, IPlayer player) {
        return false;
    }
}

class DummyCardProvider implements ICardProvider {

    int howManyCreated = 0;
    int[] deckValues;
    int defaultCardValue;

    public DummyCardProvider(int[] deckValues, int defaultCardValue){
        this.deckValues = deckValues;
        this.defaultCardValue = defaultCardValue;
    }

    int getNextAvailable(){
        if (howManyCreated < deckValues.length){
            int index = howManyCreated;
            howManyCreated += 1;
            return deckValues[index];
        } else {
            return defaultCardValue;
        }
    }

    @Override
    public Card[] getNext(int count) {
        Card[] out = new Card[count];
        for (int i = 0; i < out.length; i++) {
            out[i] = new Card(getNextAvailable());
        }
        howManyCreated += count;
        return out;
    }
}

class DummyPlayer implements IPlayer {

    private String name;
    private ArrayList<Integer> cards = new ArrayList<>();
    private int sum=0;

    public DummyPlayer(String name){
        this.name = name;
    }

    @Override
    public void acceptCards(Card[] newCards) {
        for (int i = 0; i < newCards.length; i++) {
            int cardValue = newCards[i].value;
            cards.add(cardValue);
            sum += cardValue;
        }
        System.out.println(String.format("Player %s cards: %s. Sum: %d", name, cards, sum));
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
        return sum == 21;
    }

    @Override
    public boolean isBusted() {
        return sum > 21;
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
        DummyCardProvider cardProvider = new DummyCardProvider(
                new int[]{10, 9, 5, 3, 4, 6, 100, 50, 300, 200},
                2
        );
        GameController controller = new GameController(
                new DummyGamePolicy(), cardProvider, new DummyPlayer("Dealer"), players
        );
        controller.run();

    }
}

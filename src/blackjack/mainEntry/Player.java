package blackjack.mainEntry;

import blackjack.card.Card;
import blackjack.controller.IPlayer;

import java.util.ArrayList;

public class Player implements IPlayer {

    private String name;
    private ArrayList<Integer> cards = new ArrayList<>();
    private int sum = 0;

    public Player(String name){
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
        return isBlackJack() || isBusted();
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
        System.out.println(String.format("Player %s card sum %d accredited %d", name, sum, amount));
    }

    @Override
    public int getBet() {
        return 42;
    }

    @Override
    public int getCardSum() {
        return sum;
    }
}

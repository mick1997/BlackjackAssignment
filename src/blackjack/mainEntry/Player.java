package blackjack.mainEntry;

import blackjack.card.Card;
import blackjack.controller.IPlayer;

import java.util.ArrayList;

public class Player implements IPlayer {

    // instance variable: name, cards, sum
    private String name;
    private ArrayList<Integer> cards = new ArrayList<>();
    private int sum = 0;

    /**
     * @param: name: String
     * */
    public Player(String name){
        this.name = name;
    }

    /**
     * @param: newCards: Card[]
     * @return: None
     * when dealer or player accept card each time and calculate the cards total value
     * */
    @Override
    public void acceptCards(Card[] newCards) {
        for (int i = 0; i < newCards.length; i++) {
            int cardValue = newCards[i].getFaceValue();
            cards.add(cardValue);
            sum += cardValue;
        }
        System.out.println(String.format("%s cards: %s. Sum: %d", name, cards, sum));
    }

    /**
     * @param: None
     * @return: None
     * think method that Override in realPlayer, HumanDealer or Dealer class
     * */
    @Override
    public void think() {}

    /**
     * @param: None
     * @return: boolean
     * check if it is done by determine isBlackjack or isBusted
     * */
    @Override
    public boolean isDone() {
        return isBlackJack() || isBusted();
    }

    /**
     * @param: None
     * @return: boolean
     * check if the card value is blackjack
     * */
    @Override
    public boolean isBlackJack() {
        return sum == 21;
    }

    /**
     * @param: None
     * @return: boolean
     * check if the card value is busted
     * */
    @Override
    public boolean isBusted() {
        return sum > 21;
    }

    /**
     * @param: amount: int
     * @return: None
     * print central amount of credit to add
     * */
    @Override
    public void addCredit(int amount) {
        System.out.println(String.format("%s card sum %d accredited %d", name, sum, amount));
    }

    /**
     * @param: None
     * @return: int
     * get Bet value
     * */
    @Override
    public int getBet() {
        return 10;
    }

    /**
     * @param: None
     * @return: int
     * get the total values of card
     * */
    @Override
    public int getCardSum() {
        return sum;
    }
}

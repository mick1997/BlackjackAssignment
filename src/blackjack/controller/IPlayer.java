package blackjack.controller;

import blackjack.card.Card;

public interface IPlayer {

    // acceptCards: accept next card
    void acceptCards(Card[] newCards);

    // think: logic implement
    void think();

    // isDone: if either dealer or player finish this round
    boolean isDone();

    // isBlackjack: check if it is blackjack
    boolean isBlackJack();

    // isBusted: check if it is busted
    boolean isBusted();

    // addCredit: add credit to the either dealer or players
    void addCredit(int amount);

    // getBet: get the amount of bet
    int getBet();

    // getCardSum: calculate the total sum of card
    int getCardSum();
}

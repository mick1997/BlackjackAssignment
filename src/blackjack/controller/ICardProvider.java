package blackjack.controller;

import blackjack.card.Card;

public interface ICardProvider {

    // getNext method: for get next available card
    Card[] getNext(int count);
}

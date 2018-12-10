package blackjack.controller;

import blackjack.card.Card;

public interface ICardProvider {
    Card[] getNext(int count);
}

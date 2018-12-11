package blackjack.mainEntry;

import blackjack.card.Card;
import blackjack.controller.ICardProvider;

public class CardProvider implements ICardProvider {

    private int howManyCreated = 0;
    private int[] deckValues;
    private int defaultCardValue;

    public CardProvider(int[] deckValues, int defaultCardValue) {
        this.deckValues = deckValues;
        this.defaultCardValue = defaultCardValue;
    }

    private int getNextAvailable() {
        if (howManyCreated < deckValues.length) {
            int index = howManyCreated;
            howManyCreated += 1;
            return deckValues[index];
        }
        else {
            return defaultCardValue;
        }
    }

    @Override
    public Card[] getNext(int count) {
        Card[] out = new Card[count];
        for (int i = 0; i < out.length; i++) {
            out[i] = new Card(getNextAvailable());
        }
        return out;
    }
}

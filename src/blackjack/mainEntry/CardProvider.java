package blackjack.mainEntry;

import blackjack.card.Card;
import blackjack.controller.ICardProvider;

/**
 * This class takes in a fixed group of cards and one default card.
 * It provides the next count cards from the fixed group (in the same order) until the group is exhausted
 * and then always provides the same default card.
 */

public class CardProvider implements ICardProvider {

    // instance variable: howManyCreated, deckValues, defaultCardValue
    private int howManyCreated = 0;
    private int[] deckValues;
    private int defaultCardValue;

    /**
     * @param: deckValues: int[], defaultCardValue: int
     * */
    public CardProvider(int[] deckValues, int defaultCardValue) {
        this.deckValues = deckValues;
        this.defaultCardValue = defaultCardValue;
    }

    /**
     * @param: None
     * @return: int
     * get one more card if card is less than deckValues; else, return defaultCardValue card
     * */
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

    /**
     * @param: count: int
     * @return: Card[]
     * get card every time, player or dealer wants
     * */
    @Override
    public Card[] getNext(int count) {
        Card[] out = new Card[count];
        for (int i = 0; i < out.length; i++) {
            out[i] = new Card(getNextAvailable());
        }
        return out;
    }
}

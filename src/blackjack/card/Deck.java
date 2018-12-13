package blackjack.card;

import blackjack.controller.ICardProvider;

public class Deck implements ICardProvider {

    // instance variable: cards, howManyCreated, deckValues
    private Card[] cards;
    private int howManyCreated = 0;
    private int[] deckValues;

    /**
     * @param: numberOfDeck
     * user pick the number of deck to use
     * */
    public Deck(int numberOfDeck) {
        if (numberOfDeck == 1) {
            cards = new Card[52];
            int numberOfCard = 0;
            for (int i = 1; i <= 13; i++) {
                cards[numberOfCard] = new Card(i);
            }
        }
        else {
            cards = new Card[104];
            int numberOfCard = 0;
            for (int i = 1; i <= 13; i++) {
                cards[numberOfCard] = new Card(i);
            }
        }
    }

    /**
     * @param: None
     * @return: None
     * shuffle the card
     * */
    public void shuffle() {
        int temp = 0;
        for (int i = 0; i < cards.length; i++) {
            int random = (int)(Math.random() * ((cards.length - i) + 1));
            cards[temp] = getCardAt(i);
            cards[i] = cards[random];
            cards[random] = cards[temp];
        }
    }

    /**
     * @param: position: int
     * @return: Card
     * get the position of card to do shuffle
     * */
    private Card getCardAt(int position) {
        if (position >= cards.length) {
            throw new IndexOutOfBoundsException("Values are out of bounds");
        }
        else {
            return cards[position];
        }
    }

    /**
     * @param: None
     * @return: int
     * get one more card if card is less than deckValues; else, return 0 card
     * */
    private int getNextAvailable() {
        if (howManyCreated < deckValues.length) {
            int index = howManyCreated;
            howManyCreated += 1;
            return deckValues[index];
        }
        else {
            return 0;
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

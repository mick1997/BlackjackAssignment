package blackjack.card;

import blackjack.controller.ICardProvider;

import java.util.Random;

/**
 * A collection of N card sets, each consist of a standard 52 cards. N≥1.
 * Input: Ns standard 52-card sets
 * Constraints (behavior):
     * Random shuffling: what; when; when not; how;
     * Infinite recycling: how; when; what;
     * Provide count cards: .....
 *
 * First consider the constraints because input serves the constraints and input only matters to its creator.
 *
 */
public class Deck implements ICardProvider {


    private Card[] allCards;
    private Random random = new Random();
    private int nextAvailableCardIndex = 0;

    private final static int STANDARD_CARD_SET_COUNT = 52;
    private final static String[] SUITS = {"club", "heart", "diamond", "spade"};

    public Deck(int nSets) {
        // Create N-52-card sets and assign it to this.allCards
        Card[] nSetCards = new Card[nSets * STANDARD_CARD_SET_COUNT];
        int indexInAllCards = 0;
        for (int setIndex = 0; setIndex < nSets; setIndex++) {
            for (int value = 1; value <= 13; value++) {
                for (int suitIndex = 0; suitIndex < SUITS.length; suitIndex++) {
                    String suit = SUITS[suitIndex];
                    int faceValue = value;
                    Card card = new Card(faceValue);
//                    Card card = new Card(faceValue, suit);
                    nSetCards[indexInAllCards++] = card;
                }
            }
        }
        this.allCards = nSetCards;
    }

//    public Deck(Card[] allCards) {
//        // Suppose all the cards are already there.
//        this.allCards = allCards.clone();
//    }

    private void shuffle() {
        for (int i = 0; i < allCards.length; i++) {
            int index1 = random.nextInt(allCards.length);
            int index2 = random.nextInt(allCards.length);
            Card temp = allCards[index1];
            allCards[index1] = allCards[index2];
            allCards[index2] = temp;
        }
    }

    private void reset(){
        shuffle();
        nextAvailableCardIndex = 0;
    }

    /**
     * @param: count: int
     * @return: Card[]
     * get card every time, player or dealer wants
     * */
    @Override
    public Card[] getNext(int count) {
        Card[] nextCards = new Card[count];
        for (int i = 0; i < count; i++) {
            nextCards[i] = allCards[nextAvailableCardIndex];
            nextAvailableCardIndex += 1;
            if(nextAvailableCardIndex >= allCards.length){
                reset();
            }
        }
        return nextCards;
    }
}

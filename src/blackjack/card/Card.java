package blackjack.card;

public class Card {

    // instance variable: faceValue
    private int faceValue; // 1 for A, 11 for J, 12 for Q, 13 for K

    /**
     * @param: faceValue
     * */
    public Card(int faceValue) {
        this.faceValue = faceValue;
    }

    /**
     * @param: None
     * @return: int
     * get the faceValue card
     * */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * @param: None
     * @return: String
     * print card value
     * */
    @Override
    public String toString() {
        return String.format("Card=%d ", getFaceValue());
    }
}

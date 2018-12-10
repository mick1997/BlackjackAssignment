package blackjack.card;

class RealCard {

    private int faceValue; // 1 for A, 11 for J, 12 for Q, 13 for K
    private Suit suit;

    public RealCard(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    protected Suit getSuit() {
        return suit;
    }
}

public class Card{
    public int value;
    public Card(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Card-%d", value);
    }
}

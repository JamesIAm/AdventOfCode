package y2023.Day7;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

    private CardValue cardValue;
    public Card(char cardInput) {
        this.cardValue = CardValue.getCardValue(cardInput);
    }

    public int getValue() {
        return this.cardValue.ordinal();
    }

    public boolean isJoker() {
        return this.cardValue == CardValue.JACK;
    }

    public String getHexValue() {
        return Integer.toHexString(getValue());
    }

    @Override
    public int compareTo(Card otherCard) {
        return getValue() - otherCard.getValue();
    }

    public CardValue getCardValue() {
        return this.cardValue;
    }


}

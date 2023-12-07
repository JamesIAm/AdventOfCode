package y2023.Day7.Types;

import y2023.Day7.Card;
import y2023.Day7.CardValue;

public abstract class DoubleCardType extends Type {
    private final CardValue higherCard;
    private final CardValue lowerCard;
    protected DoubleCardType(CardValue card1, CardValue card2) {
        int comparison = card1.compareTo(card2);
        if (comparison < 0) {
            this.higherCard = card1;
            this.lowerCard = card2;
        } else {
            this.higherCard = card2;
            this.lowerCard = card1;
        }
    }


//    @Override
//    public String getCardValuesAsString() {
//        return higherCard.getHexValue() + lowerCard.getHexValue();
//    }
}

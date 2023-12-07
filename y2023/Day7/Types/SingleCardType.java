package y2023.Day7.Types;

import y2023.Day7.Card;
import y2023.Day7.CardValue;

public abstract class SingleCardType extends Type {
    private final CardValue card;
    protected SingleCardType(CardValue card) {
        this.card = card;
    }


//    @Override
//    public String getCardValuesAsString() {
//        return card.getHexValue();
//    }
}

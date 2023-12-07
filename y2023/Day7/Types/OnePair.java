package y2023.Day7.Types;

import y2023.Day7.Card;
import y2023.Day7.CardValue;

public class OnePair extends SingleCardType{
    public OnePair(CardValue card) {
        super(card);
    }

    @Override
    public int getOrdinal() {
        return 5;
    }
}

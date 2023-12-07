package y2023.Day7.Types;

import y2023.Day7.Card;
import y2023.Day7.CardValue;

public class TwoPair extends DoubleCardType {
    public TwoPair(CardValue card1, CardValue card2) {
        super(card1, card2);
    }

    @Override
    public int getOrdinal() {
        return 4;
    }
}

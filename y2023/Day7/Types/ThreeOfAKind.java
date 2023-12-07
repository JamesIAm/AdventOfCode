package y2023.Day7.Types;

import y2023.Day7.Card;
import y2023.Day7.CardValue;

public class ThreeOfAKind extends SingleCardType{
    public ThreeOfAKind(CardValue card) {
        super(card);
    }

    @Override
    public int getOrdinal() {
        return 3;
    }
}

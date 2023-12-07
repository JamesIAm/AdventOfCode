package y2023.Day7.Types;

import y2023.Day7.Card;
import y2023.Day7.CardValue;

public class HighCard extends SingleCardType{
    public HighCard(CardValue card) {
        super(card);
    }

    @Override
    public int getOrdinal() {
        return 6;
    }
}

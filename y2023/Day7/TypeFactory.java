package y2023.Day7;

import y2023.Day7.Types.FiveOfAKind;
import y2023.Day7.Types.FourOfAKind;
import y2023.Day7.Types.FullHouse;
import y2023.Day7.Types.HighCard;
import y2023.Day7.Types.OnePair;
import y2023.Day7.Types.ThreeOfAKind;
import y2023.Day7.Types.TwoPair;
import y2023.Day7.Types.Type;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TypeFactory {
    private static final Comparator<Map.Entry<CardValue, Integer>> entryComparator =
            (entry1, entry2) -> {
                int countComparison = entry2.getValue() - entry1.getValue();
                if (countComparison != 0) {
                    return countComparison;
                }
                return entry1.getKey().compareTo(entry2.getKey());
            };

    private TypeFactory() {
    }

    public static Type getType(List<Card> cards) {
        TreeMap<CardValue, Integer> cardCount = new TreeMap<>();
        for (Card card : cards) {
            int currentVal = cardCount.getOrDefault(card.getCardValue(), 0);
//            if (card.isJoker()) {
//                for (Card cardIterator: Card)
//                cardCount.put()
//            } else {
                cardCount.put(card.getCardValue(), currentVal + 1);
//            }
        }
        if (cardCount.size() == 1) {
            return new FiveOfAKind(cards.get(0).getCardValue());
        }
        List<Map.Entry<CardValue, Integer>> listOfCardCounts =
                cardCount.entrySet().stream().sorted(entryComparator).toList();

        Map.Entry<CardValue, Integer> higherPower = listOfCardCounts.get(0);
        Map.Entry<CardValue, Integer> lowerPower = listOfCardCounts.get(1);

        if (higherPower.getValue() == 4) {
            return new FourOfAKind(higherPower.getKey());
        }
        if (higherPower.getValue() == 3) {
            if (lowerPower.getValue() == 2) {
                return new FullHouse(higherPower.getKey(), lowerPower.getKey());
            }
            return new ThreeOfAKind(higherPower.getKey());
        }
        if (higherPower.getValue() == 2) {
            if (lowerPower.getValue() == 2) {
                return new TwoPair(higherPower.getKey(), lowerPower.getKey());
            }
            return new OnePair(higherPower.getKey());
        }

        return new HighCard(higherPower.getKey());
    }
}

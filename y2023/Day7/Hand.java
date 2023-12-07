package y2023.Day7;

import java.util.List;
import java.util.stream.Collectors;

import y2023.Day7.Types.Type;

public class Hand implements Comparable<Hand> {
    private final int bet;
    private final List<Card> cards;

    private final String highCardScore;
    private final Type type;
    private final String inputLine;
    private final List<Card> cardsSorted;

    public Hand(String inputLine) {
        this.inputLine = inputLine;
        String[] inputs = inputLine.split(" ");
        String cardInputs = inputs[0];
        this.bet = Integer.parseInt(inputs[1]);
        this.cards = getCards(cardInputs);
        this.cardsSorted = getCardsSorted(this.cards);
        this.highCardScore = getHighCardScore(this.cards);
        this.type = TypeFactory.getType(this.cardsSorted);
    }

    private static String getHighCardScore(List<Card> cards) {
        return cards.stream()
                                       .map(card -> card.getValue())
                                       .map(Integer::toHexString)
                                       .collect(Collectors.joining());
    }

    private static List<Card> getCards(String cardInputs) {
        return cardInputs.chars()
                         .mapToObj(cardInput -> new Card((char) cardInput)).toList();
    }

    private static List<Card> getCardsSorted(List<Card> cards) {
        return cards.stream()
                         .sorted()
                         .toList();
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return inputLine + "\t" + type.getClass().getSimpleName() + "\t" + getHighCardScore();
    }

    @Override
    public int compareTo(Hand otherHand) {
        int typeComparison = otherHand.getType().compareTo(getType());
        if (typeComparison != 0) {
            return typeComparison;
        }
        return otherHand.getHighCardScore().compareTo(getHighCardScore());
    }

    public String getHighCardScore() {
        return highCardScore;
    }

    public int getBet() {
        return this.bet;
    }
}

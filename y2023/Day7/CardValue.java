package y2023.Day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum CardValue implements Comparable<CardValue>{
        ACE('A'),
        KING('K'),
        QUEEN('Q'),
        JACK('J'),
        TEN('T'),
        NINE('9'),
        EIGHT('8'),
        SEVEN('7'),
        SIX('6'),
        FIVE('5'),
        FOUR('4'),
        THREE('3'),
        TWO('2');
        private final char letter;
        private static final Map<Character, CardValue> letterMap;
        static {
            letterMap = new HashMap<>();
            Arrays.stream(CardValue.values()).forEach(value -> letterMap.put(value.letter, value));
        }
        CardValue(char letter) {
            this.letter = letter;
        }

        public static CardValue getCardValue(char fromLetter) {
            return letterMap.get(fromLetter);
        }
        
    }
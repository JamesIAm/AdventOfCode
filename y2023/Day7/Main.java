package y2023.Day7;

import java.util.ArrayList;
import java.util.List;

import y2023.usefulCode.java.ReadFile;

public class Main {
    public static void main(String[] args) {
        List<String> input = ReadFile.readInput(7);
        List<Hand> hands = new ArrayList<>();
        for (String line : input) {
            hands.add(new Hand(line));
        }
        List<Hand> sortedHands = hands.stream().sorted().toList();
        int score = 0;
        for (int i = 0; i < sortedHands.size(); i++) {
            Hand hand = sortedHands.get(i);
            int handscore = hand.getBet() * (i + 1);
            score += handscore;
            System.out.println(hand + " " + handscore);
        }
        System.out.println(score);
    }
}

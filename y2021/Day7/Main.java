package y2021.Day7;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("Day6/input.txt");
        ArrayList<String> inputs;
        try {
            Scanner in = new Scanner(file);
            inputs = new ArrayList<String>(Arrays.asList(in.nextLine().split(",")));
        } catch (Exception e) {
            System.out.println(e);
            inputs = null;
        }
        int minScore = 0;
        for (int mean = 0; mean <= Integer.parseInt(Collections.max(inputs)); mean++) {
            int score = 0;
            for (String currentCrabStr : inputs) {
                int currentCrab = Integer.parseInt(currentCrabStr);
                int baseScore = Math.abs(currentCrab - mean);
                score += (baseScore * (baseScore + 1)) / 2;
            }
            if (minScore == 0 || score < minScore) {
                minScore = score;
                System.out.println(minScore);
            }
        }

    }
}

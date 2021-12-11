package Day5;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("Day5/input.txt");
        ArrayList<String> inputs;
        try {
            Scanner in = new Scanner(file);
            inputs = new ArrayList<String>(Arrays.asList(in.nextLine().split(",")));
        } catch (Exception e) {
            System.out.println(e);
            inputs = null;
        }
        ArrayList<String> currentAges = inputs;
        for (int count = 0; count < 100; count++) {
            ArrayList<String> nextAges = new ArrayList<String>();
            for (String currentFish : currentAges) {
                int currentAge = Integer.parseInt(currentFish);
                currentAge--;
                if (currentAge < 0) {
                    currentAge = 6;
                    nextAges.add("8");
                }
                nextAges.add(currentAge + "");
            }
            currentAges = nextAges;
        }
        System.out.println(currentAges.size());
    }
}

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
        long[] ages = new long[9];
        for (String currentFish : inputs) {
            int currentAge = Integer.parseInt(currentFish);
            ages[currentAge] += 1;
        }
        for (int count = 0; count < 256; count++) {
            long[] newAges = new long[9];
            for (int index = 1; index < 9; index++) {
                newAges[index - 1] = ages[index];
            }
            newAges[6] += ages[0];
            newAges[8] += ages[0];
            ages = newAges;
        }
        for (long age : ages) {
            // System.out.println(age);
            System.out.println(Arrays.stream(ages).sum());
        }
    }
}

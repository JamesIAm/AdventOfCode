package y2021.Day1;

import java.io.InputStream;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("Day1/input.txt");
        Scanner in;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> triplets = new ArrayList<Integer>();
        try {
            in = new Scanner(inputFile);
            while (in.hasNextInt()) {
                numbers.add(in.nextInt());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int index = 0; index < numbers.size() - 2; index++) {
            int triplet = numbers.get(index) + numbers.get(index + 1) + numbers.get(index + 2);
            triplets.add(triplet);
        }
        Integer prevTriplet = 0, total = -1;
        for (Integer triplet : triplets) {
            if (triplet > prevTriplet) {
                total++;
            }
            prevTriplet = triplet;
        }
        System.out.println(total);

    }
}
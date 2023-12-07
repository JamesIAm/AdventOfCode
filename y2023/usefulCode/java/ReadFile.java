package y2023.usefulCode.java;

import static java.lang.String.format;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private ReadFile() {
    }

    public static List<String> readTestInput(int day) {
        String fileName = "testInput";
        return readFile(day, fileName);
    }

    public static List<String> readInput(int day) {
        String fileName = "input";
        return readFile(day, fileName);
    }

    private static List<String> readFile(int day, String fileName) {
        List<String> lines = new ArrayList<>();
        File inputFile = new File(format("/home/james.nahajski/workspace/AdventOfCode/y2023/Day%d/%s.txt", day,
                fileName));
        Scanner in = openScanner(inputFile);
        while (in.hasNext()) {
            lines.add(in.nextLine());
        }
        in.close();
        return lines;
    }

    private static Scanner openScanner(File inputFile) {
        try {
            return new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(format("File %s does not exist", inputFile.getAbsolutePath()), e);
        }

    }
}

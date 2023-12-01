package y2021.Day4;

import java.io.InputStream;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("Day4/input.txt");
        Scanner in;
        ArrayList<Board> boards = new ArrayList<Board>();
        String[] bingoNumbers = { "" };
        try {
            in = new Scanner(inputFile);
            ArrayList<String> boardInput = new ArrayList<String>();
            bingoNumbers = in.nextLine().split(",");
            in.nextLine();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                // // if (line.isBlank()) {
                // boards.add(new Board(boardInput));
                // boardInput = new ArrayList<String>();
                // } else {
                // boardInput.add(line.replace(" ", " ").trim());
                // }
            }
            boards.add(new Board(boardInput));
        } catch (Exception e) {
            System.out.println(e);
        }
        Board finalBoard = null;
        ArrayList<Board> toRemove = new ArrayList<Board>();
        for (String bingoNumStr : bingoNumbers) {
            if (boards.size() < 1) {
                break;
            }
            int bingoNum = Integer.parseInt(bingoNumStr);
            for (Board board : toRemove) {
                boards.remove(board);
            }
            toRemove = new ArrayList<Board>();

            for (Board board : boards) {
                if (board.setNumberActive(bingoNum)) {
                    toRemove.add(board);
                    if (boards.size() == 1) {
                        finalBoard = board;
                        break;
                    }
                }
            }
        }
        System.out.println(finalBoard.calculateScore());
        // System.out.println(bSingoNumbers[0]);
    }
}
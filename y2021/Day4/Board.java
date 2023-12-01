package y2021.Day4;

import java.util.ArrayList;

public class Board {
    Number[][] rows = new Number[5][5];
    Number[][] columns = new Number[5][5];
    ArrayList<Number> allNums = new ArrayList<Number>();
    int lastNum = 0;

    public Board(ArrayList<String> input) {

        for (int row = 0; row < 5; row++) {
            String[] strNums = input.get(row).split(" ");
            for (int column = 0; column < 5; column++) {
                int num = Integer.parseInt(strNums[column]);
                Number numObj = new Number(num);
                rows[row][column] = numObj;
                columns[column][row] = numObj;
                allNums.add(numObj);
            }
        }
    }

    public boolean setNumberActive(int num) {
        for (Number number : allNums) {
            if (number.getNum() == num) {
                number.setActive(true);
                return this.checkIfWon(num);
            }
        }
        return false;
    }

    private boolean checkIfWon(int winningNum) {
        boolean won = false;
        for (Number[] row : rows) {
            boolean winningRow = true;
            for (Number num : row) {
                if (!num.getActive()) {
                    winningRow = false;
                    break;
                }
            }
            if (winningRow) {
                won = true;
            }
        }
        for (Number[] column : columns) {
            boolean winningColumn = true;
            for (Number num : column) {
                if (!num.getActive()) {
                    winningColumn = false;
                    break;
                }
            }
            if (winningColumn) {
                won = true;
            }
        }
        if (won) {
            this.lastNum = winningNum;
        }
        return won;
    }

    public String toString() {
        String toReturn = "";
        for (Number[] row : rows) {
            for (Number num : row) {
                toReturn += num + "\t";
                // System.out.println(row[0]);

            }
            toReturn += "\n";
        }
        return toReturn;
    }

    public int calculateScore() {
        int unmarkedNumTotal = 0;
        for (Number num : allNums) {
            if (!num.getActive()) {
                unmarkedNumTotal += num.getNum();
            }
        }
        return unmarkedNumTotal * this.lastNum;
    }
}

package y2023.Day8;

import static java.lang.String.format;

enum LeftRight {
    LEFT,RIGHT;

    public static LeftRight from(char letter) {
        return switch (letter) {
            case 'R' -> RIGHT;
            case 'L' -> LEFT;
            default -> throw new IllegalArgumentException(format("letter %s is not L or R", letter));
        };
    }
}
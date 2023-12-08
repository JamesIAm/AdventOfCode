package y2023.Day8;

import java.util.List;

public class LeftRightInstructions {
    private final List<LeftRight> instructions;
    private int instructionIndex = 0;
    public LeftRightInstructions(String input) {
        instructions = input.chars().mapToObj(letter -> LeftRight.from((char) letter)).toList();
    }

    public LeftRight getNext() {
        LeftRight instruction = instructions.get(instructionIndex);
        instructionIndex ++;
        if (instructionIndex >= instructions.size()) {
            instructionIndex = 0;
        }
        return instruction;
    }


}

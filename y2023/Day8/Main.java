package y2023.Day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import y2023.usefulCode.java.ReadFile;

public class Main {
    public static void main(String[] args) {
        List<String> input = ReadFile.readInput(8);
        LeftRightInstructions leftRightInstructions = new LeftRightInstructions(input.get(0));
        List<String> nodeInput = input.subList(2, input.size());
        Node aaa = createNodes(nodeInput);
        Node currentNode = aaa;
        int count = 0;
        do {
            LeftRight next = leftRightInstructions.getNext();
            if (next == LeftRight.LEFT) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
            count++;
        } while (!currentNode.isTerminal());
        System.out.println(count);
    }

    private static Node createNodes(List<String> nodeInput) {
        Map<String, Node> emptyNodes = createEmptyNodes(nodeInput);
        Map<String, Node> filledNodes = fillNodes(emptyNodes, nodeInput);
        return filledNodes.get("AAA");
    }

    private static Map<String, Node> fillNodes(Map<String, Node> nodes, List<String> nodeInput) {
        for (String line : nodeInput) {
            Pattern leftAndRightPattern = Pattern.compile("([A-Z]+).*\\(([A-Z]+), ([A-Z]+)\\).*");
            Matcher matcher = leftAndRightPattern.matcher(line);
            matcher.find();
            String parentCode = matcher.group(1);
            String leftCode = matcher.group(2);
            String rightCode = matcher.group(3);
            Node parent = nodes.get(parentCode);
            Node left = nodes.get(leftCode);
            Node right = nodes.get(rightCode);
            parent.setLeft(left);
            parent.setRight(right);
        }
        return nodes;
    }

    private static Map<String, Node> createEmptyNodes(List<String> nodeInput) {
        Map<String, Node> emptyNodes = new HashMap<>();
        for (String line : nodeInput) {
            String nodeCode = line.split(" ")[0];
            emptyNodes.put(nodeCode, new Node(nodeCode));
        }
        return emptyNodes;
    }
}

package y2023.Day8;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
        List<Node> currentNodes = createNodes(nodeInput);
        int count = 0;
        do {
            LeftRight next = leftRightInstructions.getNext();
            currentNodes = getNewNodes2(currentNodes, next);
            if (count % 10000000 == 0) {
                System.out.printf("Depth: %d%n", count);
            }
            count++;
        } while (!areAllNodesTerminal(currentNodes));
        System.out.println(count);
    }

    private static List<Node> getNewNodes(List<Node> currentNodes, LeftRight next) {
        return currentNodes.stream().map(currentNode -> getNextNode(next, currentNode)).toList();
    }

    private static List<Node> getNewNodes2(List<Node> currentNodes, LeftRight next) {
        for (int i = 0; i < currentNodes.size(); i++) {
            currentNodes.add(i, getNextNode(next, currentNodes.get(i)));
        }
        return currentNodes;
    }

    private static boolean areAllNodesTerminal(List<Node> currentNodes) {
//        System.out.println(currentNodes);
        for (Node node : currentNodes) {
            if (!node.isTerminal()) {
                return false;
            }
        }
        return true;
    }

    private static Node getNextNode(LeftRight nextInstruction, Node currentNode) {
        if (nextInstruction == LeftRight.LEFT) {
            return currentNode.getLeft();
        } else {
            return currentNode.getRight();
        }
    }

    private static List<Node> createNodes(List<String> nodeInput) {
        Map<String, Node> emptyNodes = createEmptyNodes(nodeInput);
        Map<String, Node> filledNodes = fillNodes(emptyNodes, nodeInput);
        return getStartNodes(filledNodes);
    }

    private static List<Node> getStartNodes(Map<String, Node> filledNodes) {
        List<Node> startNodes = new LinkedList<>();
        for (Map.Entry<String, Node> node : filledNodes.entrySet()) {
            if (node.getKey().charAt(node.getKey().length() - 1) == 'A') {
                startNodes.add(node.getValue());
            }
        }
        return startNodes;
    }

    private static Map<String, Node> fillNodes(Map<String, Node> nodes, List<String> nodeInput) {
        for (String line : nodeInput) {
            Pattern leftAndRightPattern = Pattern.compile("([A-Z0-9]+).*\\(([A-Z0-9]+), ([A-Z0-9]+)\\).*");
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

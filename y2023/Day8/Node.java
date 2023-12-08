package y2023.Day8;

import java.util.Objects;

public class Node {
    private final String nodeCode;
    private final boolean isTerminal;
    private Node left;
    private Node right;
    public Node(String nodeCode) {
        this.nodeCode = nodeCode;
        this.isTerminal = this.nodeCode.charAt(nodeCode.length() - 1) == 'Z';

    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return nodeCode;
    }
}

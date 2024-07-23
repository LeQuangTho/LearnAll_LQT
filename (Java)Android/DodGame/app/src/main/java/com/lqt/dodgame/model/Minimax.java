package com.lqt.dodgame.model;

public class Minimax {

    public int minVal(Node node, int depth) {
        int val = Integer.MAX_VALUE;

        if (depth == 0 || node.isNodeEnd()) {
            return node.getSumPoint();
        } else {
            for (Node node2 : node.getNextNodes()) {
                int t = maxVal(node2, depth - 1);
                if (val >= t) {
                    val = t;
                }
            }
            return val;
        }
    }

    public int maxVal(Node node, int depth) {
        int val = Integer.MIN_VALUE;

        if (depth == 0 || node.isNodeEnd()) {
            return node.getSumPoint();
        } else {
            for (Node node2 : node.getNextNodes()) {
                int t = minVal(node2, depth - 1);
                if (val <= t) {
                    val = t;
                }
            }
            return val;
        }
    }

    public Node MiniMaxVal(Node node, int depth) {
        Node chooseNode = null;

        int val = Integer.MIN_VALUE;

        for (Node node2 : node.getNextNodes()) {
            int t = minVal(node2, depth - 1);
            if (val <= t) {
                val = t;
                chooseNode = node2;
            }
        }

        return chooseNode;
    }
}

package com.yql;

import java.util.Stack;

public class DFSTree {

    public static void main(String[] args) {

    }

    public int dfs(Node head) {
        if (head == null) {
            return 0;
        }

        Node node;
        Stack<Node> s = new Stack<>();
        s.push(head);
        while (head.left != null) {


        }

        return 0;
    }

    public class Node {
        public int val;
        public Node left;
        public Node right;
    }
}

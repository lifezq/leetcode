package com.yql;

import java.util.Stack;

public class DFSTree {

    public static void main(String[] args) {
        Node head = new DFSTree().new Node(1);
        head.left = new DFSTree().new Node(2);
        head.right = new DFSTree().new Node(3);
        head.left.left = new DFSTree().new Node(4);
        head.left.right = new DFSTree().new Node(5);
        head.right.left = new DFSTree().new Node(6);
        head.right.right = new DFSTree().new Node(7);

        new DFSTree().dfs1(head);
        System.out.println("");
        new DFSTree().dfsPreOrder(head);
        System.out.println("");
        new DFSTree().dfsInOrder(head);
    }

    public int dfs(Node head) {
        if (head == null) {
            return 0;
        } else {
            int leftHeight = dfs(head.left);
            int rightHeight = dfs(head.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public void dfs1(Node head) {
        if (head == null) {
            return;
        }

        System.out.printf("%d,", head.val);
        dfs1(head.left);
        dfs1(head.right);
    }

    //前序遍历
    public void dfsPreOrder(Node head) {
        if (head == null) {
            return;
        }

        Node node;
        Stack<Node> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            node = s.pop();

            System.out.printf("%d,", node.val);
            if (node.right != null) {
                s.push(node.right);
            }

            if (node.left != null) {
                s.push(node.left);
            }
        }
    }

    //中序遍历
    public void dfsInOrder(Node head) {
        if (head == null) {
            return;
        }

        Node node = head;
        Stack<Node> s = new Stack<>();
        while (node != null || !s.isEmpty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }

            if (!s.isEmpty()) {
                node = s.pop();
                System.out.printf("%d,", node.val);
                node = node.right;
            }
        }
    }

    public class Node {
        
        public int val;
        public Node left;
        public Node right;


        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}

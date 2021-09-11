package com.yql;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BFSTree {


    public static void main(String[] args) {
        Node node = new BFSTree().new Node(1);
        node.left = new BFSTree().new Node(2);
        node.right = new BFSTree().new Node(3);
        node.left.left = new BFSTree().new Node(4);
        node.left.right = new BFSTree().new Node(5);
        node.right.left = new BFSTree().new Node(6);
        node.right.right = new BFSTree().new Node(7);

        bfs(node);
    }

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> q = new LinkedBlockingQueue<>();
        q.add(node);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node n = q.poll();
                System.out.printf("%d,", n.val);

                if (n.left != null) {
                    q.add(n.left);
                }

                if (n.right != null) {
                    q.add(n.right);
                }
            }
            System.out.println(" ");
        }
    }

    public class Node {
        public Integer val;
        public Node left;
        public Node right;

        Node() {

        }

        Node(Integer val) {
            this.val = val;
        }
    }
}

package com.yql;

import java.util.Stack;

public class StringToTreeNode {

    public static void main(String[] args) {
        Node head = new StringToTreeNode().createNodeByString("A(B(C),D(,E))");
        new StringToTreeNode().bfs(head);
    }

    public void bfs(Node head) {
        if (head == null) {
            return;
        }

        Node node;
        Stack<Node> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            int size = s.size();
            for (int i = 0; i < size; i++) {
                node = s.pop();

                System.out.printf("%c,", node.val);

                if (node.right != null) {
                    s.push(node.right);
                }

                if (node.left != null) {
                    s.push(node.left);
                }
            }
        }
    }

    // A(B(C(,),),E(,))
    // A(B(C),D(,E))
    public Node createNodeByString(String s) {
        Node root = null;
        Node cur = null;
        int flag = 0;
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    if (cur != null) {
                        stack.push(cur);
                    }
                    flag = 1;
                    break;
                case ')':
                    stack.pop();
                    break;
                case ',':
                    flag = 2;
                    break;
                default:
                    cur = new Node(c);
                    if (root == null) {
                        root = cur;
                    }

                    if (flag == 1) {
                        stack.peek().left = cur;
                    } else if (flag == 2) {
                        stack.peek().right = cur;
                    }

                    flag = 0;
            }
        }

        return root;
    }

    public class Node {
        char val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(char val) {
            this.val = val;
        }
    }
}



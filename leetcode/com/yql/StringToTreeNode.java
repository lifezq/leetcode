package com.yql;

import java.util.Stack;

public class StringToTreeNode {
    // A(B(C(,),),E(,))
    public Node createByString(String s) {
        Node root = null;
        Node cur = null;
        int flag = 3;
        Stack<Node> s = new Stack<>();
        for (char c : s) {
            switch (c) {
                case "(":
                    if (cur != null)
                        s.push(cur);
                    flag = 1;
                case ")":
                    //s.pop();
                    flag = 2
                case ",":
                    flag = 3;
                default:
                    cur = new Node(c);
                    if (root == null) {
                        root = cur;
                    }

                    if (flag == 1) {
                        s.pop().left = cur;
                    } else if (flag == 2) {
                        s.pop().right = cur;
                    }
            }
        }
    }

    public class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}



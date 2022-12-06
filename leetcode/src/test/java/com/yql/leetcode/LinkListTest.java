package com.yql.leetcode;


import org.junit.jupiter.api.Test;

public class LinkListTest {
    private Node head;

    {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
    }

    @Test
    public void testReverse() {
        print(reverse());
    }

    @Test
    public void testFindKthToTail() {
        Node node = findKthToTail(2);
        if (node != null) {
            System.out.println(node.data);
        }
    }

    @Test
    public void testReverseRange() {
        print(reverseRange(2, 4));
    }

    private Node reverseRange(int from, int to) {
        Node root = head;
        Node newHead = null;
        Node temp;
        Node cutHead = null;

        int idx = 0;
        while (root != null) {
            idx++;

            if (idx < from) {
                cutHead = root;
            }

            if (idx >= from && idx <= to) {
                temp = root.next;
                root.next = newHead;
                newHead = root;
                root = temp;
                continue;
            }

            if (idx > to) {
                break;
            }

            root = root.next;
        }

        if (cutHead != null) {
            cutHead.next = newHead;
        } else {
            head = newHead;
        }

        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = root;

        return head;
    }

    private Node findKthToTail(int k) {
        Node fast = head;
        Node slow = head;

        for (int i = 1; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    private void print(Node node) {
        while (node != null) {
            System.out.printf("%d,", node.data);
            node = node.next;
        }
        System.out.println("");
    }

    private Node reverse() {
        Node node = head;
        Node newHead = null;
        Node temp;
        while (node != null) {
            temp = node.next;
            node.next = newHead;
            newHead = node;
            node = temp;
        }
        return newHead;
    }

    class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
        }
    }
}

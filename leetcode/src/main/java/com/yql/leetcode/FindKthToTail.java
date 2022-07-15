package com.yql.leetcode;

public class FindKthToTail {

    public static void main(String[] args) {
        Node head = new FindKthToTail().new Node(1);
        head.next = new FindKthToTail().new Node(2);
        head.next.next = new FindKthToTail().new Node(3);
        head.next.next.next = new FindKthToTail().new Node(4);
        head.next.next.next.next = new FindKthToTail().new Node(5);
        head.next.next.next.next.next = new FindKthToTail().new Node(6);

        System.out.println(new FindKthToTail().findKthToTail(head, 2).val);
    }

    public Node findKthToTail(Node head, int k) {
        if (head == null) {
            return null;
        }

        if (k <= 0) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        //快的指针跑到了第k-1个节点处(默认第一个节点是1而不是0)
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

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }


        public Node() {
        }
    }
}

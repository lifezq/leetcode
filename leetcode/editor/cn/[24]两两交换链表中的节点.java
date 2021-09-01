package editor.cn;

/**
 * 题目Id：24;
 * 题目：两两交换链表中的节点，swap-nodes-in-pairs;
 * 日期：2021-09-01 17:48:55
 */

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 1027 👎 0


class P_24_SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P_24_SwapNodesInPairs().new Solution();
        Solution.ListNode l0 = solution.newListNode(1);
        l0.next = solution.newListNode(2);
        l0.next.next = solution.newListNode(3);
        l0.next.next.next = solution.newListNode(4);
        Solution.ListNode ret = solution.swapPairs(l0);
        Solution.ListNode l1 = ret;
        while (l1 != null) {
            System.out.printf("%d->", l1.val);
            l1 = l1.next;
        }

        System.out.println(" ");

        Solution.ListNode l2 = solution.reverse(ret);
        while (l2 != null) {
            System.out.printf("%d->", l2.val);
            l2 = l2.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            int val = 0;
            ListNode node = head;
            while (head != null && head.next != null) {
                val = head.val;
                head.val = head.next.val;
                head.next.val = val;
                head = head.next.next;
            }
            return node;
        }

        public ListNode reverse(ListNode head) {
            ListNode newHead = null;
            ListNode temp = null;
            while (head != null) {
                temp = head.next;
                head.next = newHead;
                newHead = head;
                head = temp;
            }
            return newHead;
        }

        public ListNode newListNode(int val) {
            return new ListNode(val);
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;

/**
 * 题目Id：25;
 * 题目：K 个一组翻转链表，reverse-nodes-in-k-group;
 * 日期：2021-09-01 18:20:02
 */

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 递归 链表 
// 👍 1268 👎 0


class P_25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P_25_ReverseNodesInKGroup().new Solution();
        Solution.ListNode l0 = solution.newListNode(1);
        l0.next = solution.newListNode(2);
        l0.next.next = solution.newListNode(3);
        l0.next.next.next = solution.newListNode(4);
        l0.next.next.next.next = solution.newListNode(5);

        Solution.ListNode ret = solution.reverseKGroup(l0, 3);
        while (ret != null) {
            System.out.printf("%d->", ret.val);
            ret = ret.next;
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode newHead = null;
            ListNode tempHead = null;
            ListNode temp = null;

            int idx = 1;
            boolean isReverse = true;
            while (head != null) {

                if (isReverse) {

                    temp = head.next;
                    head.next = newHead;
                    newHead = head;
                    head = temp;
                } else {

                    tempHead = mergeLists(tempHead, newHead);
                    tempHead = mergeLists(tempHead, new ListNode(head.val));
                    newHead = null;
                    head = head.next;
                }

                if (idx % k == 0) {
                    isReverse = !isReverse;
                }

                idx++;
            }
            return tempHead;
        }

        public ListNode mergeLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            ListNode head = l1;
            while (l1.next != null) {
                l1 = l1.next;
            }
            l1.next = l2;
            return head;
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
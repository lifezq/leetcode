package editor.cn;

/**
 * 题目Id：61;
 * 题目：旋转链表，rotate-list;
 * 日期：2021-09-02 19:07:58
 */

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 618 👎 0


class P_61_RotateList {
    public static void main(String[] args) {
        Solution solution = new P_61_RotateList().new Solution();
        Solution.ListNode l0 = solution.newListNode(1);
        l0.next = solution.newListNode(2);
        l0.next.next = solution.newListNode(3);
        l0.next.next.next = solution.newListNode(4);
        Solution.ListNode ret = solution.rotateRight(l0, 6);

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
        public ListNode rotateRight(ListNode head, int k) {
            ListNode node = head;

            int idx = 0;
            while (node != null) {
                idx++;
                node = node.next;
            }

            if (k == idx) {
                return head;
            }

            if (k > idx) {
                k = k % idx;
            }

            ListNode newHead = null;

            idx = 0;
            for (int i = 0; i < k; i++) {
                ListNode temp = head != null ? head : newHead;
                ListNode temp1 = temp;
                ListNode head1 = newHead == null ? temp : newHead;
                int lastIdx = 0;
                while (temp.next != null) {
                    lastIdx++;
                    temp = temp.next;
                }

                newHead = new ListNode(temp.val);
                idx = 0;
                while (temp1.next != null) {
                    if (idx == lastIdx - 1) {
                        temp1.next = null;
                        break;
                    }
                    temp1 = temp1.next;
                    idx++;
                }

                if (lastIdx == 0) {
                    head = null;
                }

                newHead.next = head1;
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
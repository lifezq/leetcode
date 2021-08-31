package editor.cn;

/**
 * 题目Id：2;
 * 题目：两数相加，add-two-numbers;
 * 日期：2021-08-31 10:54:36
 */

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6673 👎 0


class P_2_AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new P_2_AddTwoNumbers().new Solution();
        Solution.ListNode l1 = solution.newListNode(2);
        l1.next = solution.newListNode(4);
        l1.next.next = solution.newListNode(3);
        Solution.ListNode l2 = solution.newListNode(5);
        l2.next = solution.newListNode(6);
        l2.next.next = solution.newListNode(4);

        Solution.ListNode ret = solution.addTwoNumbers(l1, l2);
        while (ret != null) {
            System.out.printf(ret.val + "->");
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ret = new ListNode();
            ListNode head = ret;
            boolean upper = false;
            while (l1 != null) {

                if (upper) {
                    l1.val += 1;
                    upper = false;
                }

                if (l2 != null) {
                    ret.val = l1.val + l2.val;

                    if (ret.val > 9) {
                        ret.val = ret.val - 10;
                        upper = true;
                    }

                    l2 = l2.next;
                } else {
                    ret.val = l1.val;
                }

                if (l1.next != null) {
                    ret.next = new ListNode();
                    ret = ret.next;
                }

                l1 = l1.next;
            }

            while (l2 != null) {

                if (upper) {
                    l2.val += 1;
                    upper = false;
                }

                if (l2.val > 9) {
                    l2.val = l2.val - 10;
                    upper = true;
                }

                ret.val = l2.val;
                ret.next = l2.next;
                l2 = l2.next;
            }

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
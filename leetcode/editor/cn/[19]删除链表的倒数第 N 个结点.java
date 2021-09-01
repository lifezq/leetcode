package editor.cn;

/**
 * 题目Id：19;
 * 题目：删除链表的倒数第 N 个结点，remove-nth-node-from-end-of-list;
 * 日期：2021-09-01 10:57:07
 */

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1534 👎 0


class P_19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P_19_RemoveNthNodeFromEndOfList().new Solution();
        Solution.ListNode l0 = solution.newListNode(1);
        l0.next = solution.newListNode(2);
        l0.next.next = solution.newListNode(3);
        l0.next.next.next = solution.newListNode(4);
        l0.next.next.next.next = solution.newListNode(5);

        Solution.ListNode l1 = solution.removeNthFromEnd(l0, 2);
        while (l1 != null) {
            System.out.printf("%d->", l1.val);
            l1 = l1.next;
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = head;
            int idx = 0;
            while (head != null) {
                idx++;
                head = head.next;
            }
            
            int index = idx - n;
            idx = 0;
            ListNode newHead = node;
            while (newHead != null) {
                if (index == idx + 1) {
                    newHead.next = newHead.next.next;
                }
                idx++;
                newHead = newHead.next;
            }
            return node;
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
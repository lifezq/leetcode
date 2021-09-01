package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目Id：23;
 * 题目：合并K个升序链表，merge-k-sorted-lists;
 * 日期：2021-09-01 17:06:21
 */

//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1488 👎 0


class P_23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P_23_MergeKSortedLists().new Solution();
        Solution.ListNode l0 = solution.newListNode(1);
        l0.next = solution.newListNode(4);
        l0.next.next = solution.newListNode(5);

        Solution.ListNode l1 = solution.newListNode(1);
        l1.next = solution.newListNode(3);
        l1.next.next = solution.newListNode(4);

        Solution.ListNode l2 = solution.newListNode(2);
        l2.next = solution.newListNode(6);
        l2.next.next = solution.newListNode(8);

        Solution.ListNode[] l3 = new Solution.ListNode[3];
        l3[0] = l0;
        l3[1] = l1;
        l3[2] = l2;

        Solution.ListNode ret = solution.mergeKLists(l3);
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
        public ListNode mergeKLists(ListNode[] lists) {
            List<Integer> vals = new ArrayList<>();
            for (ListNode list : lists) {
                while (list != null) {
                    vals.add(list.val);
                    list = list.next;
                }
            }

            int[] arr = new int[vals.size()];
            for (int i = 0; i < vals.size(); i++) {
                arr[i] = vals.get(i);
            }
            quickSort(arr, 0, arr.length - 1);

            ListNode ret = new ListNode();
            ListNode head = ret;
            for (int i = 0; i < arr.length; i++) {
                ret.val = arr[i];

                if (i < arr.length - 1) {
                    ret.next = new ListNode();
                    ret = ret.next;
                }
            }
            return head;
        }

        public void quickSort(int[] arr, int low, int high) {
            if (low >= high) {
                return;
            }

            int i = low, j = high, pivot = arr[low];
            while (i < j) {
                while (i < j && arr[j] >= pivot) {
                    j--;
                }

                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && arr[i] <= pivot) {
                    i++;
                }

                if (i < j) {
                    arr[j--] = arr[i];
                }
            }

            arr[i] = pivot;

            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
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
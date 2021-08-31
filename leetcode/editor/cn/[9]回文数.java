package editor.cn;

/**
 * 题目Id：9;
 * 题目：回文数，palindrome-number;
 * 日期：2021-08-31 12:58:39
 */

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1604 👎 0


class P_9_PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P_9_PalindromeNumber().new Solution();
        int v = 121;
        System.out.printf("整数[%d]是否为回文数结果：%s\n", v, solution.isPalindrome(v));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            String s = Integer.valueOf(x).toString();
            int left = 0, right = 0;
            if (s.length() % 2 == 0) {
                if (s.charAt(s.length() / 2 - 1) != s.charAt(s.length() / 2)) {
                    return false;
                }

                left = s.length() / 2 - 1 - 1;
                right = s.length() / 2 + 1;
            } else {
                left = s.length() / 2 - 1;
                right = s.length() / 2 + 1;
            }

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left--;
                right++;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
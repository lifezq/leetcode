package editor.cn;

/**
 * 题目Id：32;
 * 题目：最长有效括号，longest-valid-parentheses;
 * 日期：2021-09-02 11:52:11
 */

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1441 👎 0


class P_32_LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P_32_LongestValidParentheses().new Solution();
        String s = ")()())";
        System.out.println(solution.longestValidParentheses(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int max = 0;
            int maxLength = 0;
            int balance = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    balance++;
                } else {
                    balance--;
                }

                if (balance < 0) {
                    maxLength = Math.max(maxLength, max);
                    max = 0;
                    balance = 0;
                    continue;
                }

                max++;
            }

            while (balance > 0) {
                max--;
                balance--;
            }

            maxLength = Math.max(maxLength, max);

            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
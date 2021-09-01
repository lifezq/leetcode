package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目Id：22;
 * 题目：括号生成，generate-parentheses;
 * 日期：2021-09-01 11:38:22
 */

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2008 👎 0


class P_22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P_22_GenerateParentheses().new Solution();
        List<String> ret = solution.generateParenthesis(3);
        for (String s : ret) {
            System.out.printf("%s-", s);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ret = new ArrayList<>();
            backTrack(ret, new StringBuilder(), 0, 0, n);
            return ret;
        }

        public void backTrack(List<String> ret, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                if (valid(cur.toString().toCharArray())) {
                    ret.add(cur.toString());
                }
                return;
            }

            if (open < max) {
                cur.append("(");
                backTrack(ret, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }

            if (close < max) {
                cur.append(")");
                backTrack(ret, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') {
                    ++balance;
                } else {
                    --balance;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4034 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public static String longestPalindrome(String s) {
        int curr = 0;
        int left = 0;
        int right = 0;
        String sub = "";

        // 234456
        // curr=2, left=1, right=3+1
        // left++=2, right--=3
        // abcdedcbs
        // curr=4, left=3, right=5
        // left=1, right=7
        while (curr < s.length()) {

            left = curr - 1;
            right = curr + 1;
            if (right < s.length() && s.charAt(curr) == s.charAt(right)) {
                String val = s.substring(curr, right + 1);
                sub = val.length() > sub.length() ? val : sub;
                right++;
            }

            List<Character> cs = new ArrayList<>();
            while (left >= 0 && right < s.length()) {

                if (s.charAt(left) == s.charAt(right)) {
                    String val = s.substring(left, right + 1);
                    sub = val.length() > sub.length() ? val : sub;
                } else {
                    break;
                }

                left--;
                right++;
            }

            curr++;
        }

        return sub;
    }

    public static void main(String[] args) {
        String s = "abcdedcbs";
        System.out.printf("字符串[%s]最长回文子串为：%s\n", s, longestPalindrome(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

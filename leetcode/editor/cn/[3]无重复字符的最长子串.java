package editor.cn;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 6009 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        List<Character> cs = new ArrayList<>();
        String ms = "";
        Integer max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cs.contains(s.charAt(i))) {
                if (cs.size() > max) {
                    max = cs.size();
                    ms = cs.toString();
                }
                cs.clear();
            }
            cs.add(s.charAt(i));
        }

        System.out.println("最长子串：" + ms);
        return max;
    }

    //    [1,2,3]
    public static int lengthOfLongestSubstringSlideWindow(String s) {
        int max = 0;
        int first = 0;
        int second = first + 1;
        int size = s.length();
        String str = "";
        while (second < size) {
            str = s.substring(first, second);
            if (str.indexOf(s.charAt(second)) >= 0) {
                max = Math.max(second - first, max);
                first = second;
                second = first + 1;
            }

            second++;
        }

        return max;
    }


    public static void main(String[] args) {
        String s = "dsafsadfsaffdsfdsssddhfdfnbvmfffdg";
        System.out.println("字符串[" + s + "]无重复字符最长子串长度：" + lengthOfLongestSubstringSlideWindow(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

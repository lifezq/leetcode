package editor.cn;

/**
 * 题目Id：67;
 * 题目：二进制求和，add-binary;
 * 日期：2021-09-04 10:17:14
 */

//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 669 👎 0


class P_67_AddBinary {
    public static void main(String[] args) {
        Solution solution = new P_67_AddBinary().new Solution();
        System.out.println("ans:" + solution.addBinary("1010", "1011"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String addBinary(String a, String b) {
            if (a.isEmpty()) {
                return b;
            }

            if (b.isEmpty()) {
                return a;
            }

            int val;
            StringBuilder ans = new StringBuilder("");
            boolean upper = false;
            for (int i = a.length() - 1; i >= 0; i--) {

                if (b.length() == 0) {
                    if (upper) {
                        val = (a.charAt(i) - '0') + ('1' - '0');
                    } else {
                        val = a.charAt(i) - '0';
                    }

                    upper = compute(ans, val);
                    continue;
                }

                val = (a.charAt(i) - '0') + (b.charAt(b.length() - 1) - '0');
                if (upper) {
                    val++;
                }

                upper = compute(ans, val);


                b = b.substring(0, b.length() - 1);
            }

            if (upper && b.length() == 0) {
                ans.insert(0, "1");
            }

            while (b.length() > 0) {
                if (upper) {
                    val = b.charAt(b.length() - 1) + '1' - '0';
                } else {
                    val = b.charAt(b.length() - 1) - '0';
                }

                upper = compute(ans, val);
                b = b.substring(0, b.length() - 1);
            }

            return ans.toString();
        }

        public boolean compute(StringBuilder ans, int val) {
            String numStr;
            boolean upper;
            if (val >= 2) {

                upper = true;
                numStr = String.valueOf(val - 2);
                ans.insert(0, numStr);
            } else {

                numStr = String.valueOf(val);
                ans.insert(0, numStr);
                upper = false;
            }

            return upper;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
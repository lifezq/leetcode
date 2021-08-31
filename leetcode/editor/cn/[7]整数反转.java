package editor.cn;

/**
 * 题目Id：7;
 * 题目：整数反转，reverse-integer;
 * 日期：2021-08-31 12:13:00
 */

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 3027 👎 0


class P_7_ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P_7_ReverseInteger().new Solution();
        int v = -123;
        System.out.printf("整数[%d]反转后结果：%d\n", v, solution.reverse(v));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            String str = Integer.valueOf(x).toString();

            StringBuilder sb = new StringBuilder();
            if (str.charAt(0) == '-') {
                str = str.substring(1);
                sb.append('-');
            }


            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }

            return Integer.parseInt(sb.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
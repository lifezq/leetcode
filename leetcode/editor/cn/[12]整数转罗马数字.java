package editor.cn;

/**
 * 题目Id：12;
 * 题目：整数转罗马数字，integer-to-roman;
 * 日期：2021-08-31 15:44:36
 */

//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 678 👎 0


class P_12_IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new P_12_IntegerToRoman().new Solution();
        int v = 1994;
        System.out.printf("整数[%d]转罗马结果为:%s\n", v, solution.intToRomanFast(v));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public final int[] romanNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        public final String[] romanStrings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRomanFast(int num) {
            int value;
            String symbol;
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < romanNumbers.length; i++) {
                value = romanNumbers[i];
                symbol = romanStrings[i];
                while (num >= value) {
                    num -= value;
                    ret.append(symbol);
                }
            }
            return ret.toString();
        }

        public String intToRoman(int num) {
            int val = 0;
            StringBuilder ret = new StringBuilder();
            if (num / 1000 > 0) {
                val = num / 1000;
                num = num - val * 1000;
                for (int i = 0; i < val; i++) {
                    ret.append("M");
                }
            }

            if (num / 100 > 0) {
                val = num / 100;
                if (val == 9) {
                    ret.append("CM");
                } else if (val >= 5) {
                    ret.append("D");
                    val = val - 5;
                    for (int i = 0; i < val; i++) {
                        ret.append("C");
                    }
                } else if (val == 4) {
                    ret.append("CD");
                } else {
                    val = num / 100;
                    for (int i = 0; i < val; i++) {
                        ret.append("C");
                    }
                }

                num = num - (num / 100) * 100;
            }

            if (num / 10 > 0) {
                val = num / 10;
                if (val == 9) {
                    ret.append("XC");
                } else if (val >= 5) {
                    ret.append("L");
                    val = val - 5;
                    for (int i = 0; i < val; i++) {
                        ret.append("X");
                    }
                } else if (val == 4) {
                    ret.append("XL");
                } else {
                    for (int i = 0; i < val; i++) {
                        ret.append("X");
                    }
                }

                num = num - (num / 10) * 10;
            }

            val = num;
            if (val == 9) {
                ret.append("IX");
            } else if (val >= 5) {
                ret.append("V");
                val = val - 5;
                for (int i = 0; i < val; i++) {
                    ret.append("I");
                }
            } else if (val == 4) {
                ret.append("IV");
            } else {
                for (int i = 0; i < val; i++) {
                    ret.append("I");
                }
            }

            return ret.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
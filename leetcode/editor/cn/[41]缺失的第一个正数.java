package editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目Id：41;
 * 题目：缺失的第一个正数，first-missing-positive;
 * 日期：2021-09-02 18:01:57
 */

//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 哈希表 
// 👍 1190 👎 0


class P_41_FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new P_41_FirstMissingPositive().new Solution();
        int[] nums = {3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            // 1,2,0  , 输出3
            Map<Integer, Integer> m = new HashMap<>();
            for (int num : nums) {
                m.put(num, 1);
            }
            
            int i = 1;
            while (i > 0) {
                if (!m.containsKey(i)) {
                    return i;
                }
                i++;
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
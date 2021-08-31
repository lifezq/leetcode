package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目Id：15;
 * 题目：三数之和，3sum;
 * 日期：2021-08-31 17:22:21
 */

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3691 👎 0


class P_15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P_15_ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.printf("三数[%s]之和结果为：%s\n", nums, solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return null;
            }

            List<List<Integer>> ret = new ArrayList<>();

            int left = 0, middle = 1, right = 2;
            // 1,2,3,4
            while (left < nums.length - 2) {

                if (nums[left] + nums[middle] + nums[right] == 0) {

                    boolean found = false;
                    for (int i = 0; i < ret.size(); i++) {
                        List<Integer> item = ret.get(i);
                        if (item.contains(nums[left]) && item.contains(nums[middle]) && item.contains(nums[right])) {
                            found = true;
                        }
                    }

                    if (!found) {
                        List<Integer> val = new ArrayList<>();
                        val.add(nums[left]);
                        val.add(nums[middle]);
                        val.add(nums[right]);
                        ret.add(val);
                    }
                }

                if (right < nums.length - 1) {
                    right++;
                } else {
                    middle++;
                    right = middle + 1;
                }

                if (middle >= nums.length - 1) {
                    left++;
                    middle = left + 1;
                    right = left + 2;
                }
            }

            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
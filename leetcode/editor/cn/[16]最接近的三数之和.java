package editor.cn;

/**
 * 题目Id：16;
 * 题目：最接近的三数之和，3sum-closest;
 * 日期：2021-08-31 18:18:40
 */

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 865 👎 0


class P_16_ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P_16_ThreeSumClosest().new Solution();
        int[] nums = {-1, 2, 1, -4};
        System.out.println("最接近的三数之和：" + solution.threeSumClosest(nums, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums.length < 3) {
                return 0;
            }

            int left = 0, middle = 1, right = 2;

            int min = Math.abs(nums[left] + nums[middle] + nums[right] - target);
            int val;
            int sum = nums[left] + nums[middle] + nums[right];
            //1,2,3,4
            while (left < nums.length - 2) {
                val = nums[left] + nums[middle] + nums[right];
                if (Math.abs(val - target) < min) {
                    min = Math.abs(val - target);
                    sum = val;
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

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;

/**
 * 题目Id：34;
 * 题目：在排序数组中查找元素的第一个和最后一个位置，find-first-and-last-position-of-element-in-sorted-array;
 * 日期：2021-09-02 12:16:32
 */

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1181 👎 0


class P_34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P_34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ret0 = solution.searchRange(nums, 8);
        int[] ret1 = solution.searchRange2(nums, 8);
        System.out.println("ret0:" + ret0[0] + "," + ret0[1]);
        System.out.println("ret1:" + ret1[0] + "," + ret1[1]);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] idx = {-1, -1};
            for (int i = 0; i < nums.length; i++) {

                if (nums[i] == target) {
                    if (idx[0] == -1) {
                        idx[0] = i;
                        idx[1] = i;
                    } else {
                        idx[1] = i;
                    }
                }
            }

            return idx;
        }

        public int[] searchRange2(int[] nums, int target) {
            int[] idx = {-1, -1};

            if (nums.length == 0) {
                return idx;
            }

            int left = 0, right = nums.length - 1;
            int mid = (right - left) / 2;
            while (mid > 0) {
                if (nums[mid] > target) {
                    mid = (mid - left) / 2;
                } else if (nums[mid] < target) {
                    mid = mid + (right - mid) / 2;
                } else {
                    break;
                }
            }

            if (mid >= 0) {
                int i = mid, j = mid;
                while (i >= 0) {
                    if (nums[i] == target) {
                        idx[0] = i;
                    } else {
                        break;
                    }
                    i--;
                }

                while (j < nums.length) {
                    if (nums[j] == target) {
                        idx[1] = j;
                    } else {
                        break;
                    }
                    j++;
                }
            }

            return idx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目Id：18;
 * 题目：四数之和，4sum;
 * 日期：2021-09-01 09:52:35
 */

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] ： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 932 👎 0


class P_18_FourSum {
    public static void main(String[] args) {
        Solution solution = new P_18_FourSum().new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> ret = solution.fourSum(nums, 0);
        for (List<Integer> integers : ret) {
            integers.forEach(x -> {
                System.out.printf("%d,", x);
            });
            System.out.println(" ");
        }

        System.out.println("------------");

        ret = solution.fourSum2(nums, 0);
        for (List<Integer> integers : ret) {
            integers.forEach(x -> {
                System.out.printf("%d,", x);
            });
            System.out.println(" ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums.length < 4) {
                return null;
            }

            List<List<Integer>> ret = new ArrayList<>();
            int left = 0, middleLeft = 1, middleRight = 2, right = 3;
            while (left < nums.length - 3) {
                if (nums[left] + nums[middleLeft] + nums[middleRight] + nums[right] == target) {
                    boolean found = false;
                    for (List<Integer> integers : ret) {
                        if (integers.contains(nums[left]) && integers.contains(nums[middleLeft]) &&
                                integers.contains(nums[middleRight]) && integers.contains(nums[right])) {
                            found = true;
                        }
                    }

                    if (!found) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[left]);
                        item.add(nums[middleLeft]);
                        item.add(nums[middleRight]);
                        item.add(nums[right]);
                        ret.add(item);
                    }
                }

                if (right < nums.length - 1) {
                    right++;
                } else {
                    middleRight++;
                    right = middleRight + 1;
                }

                if (middleRight > nums.length - 2) {
                    middleLeft++;
                    middleRight = middleLeft + 1;
                    right = middleLeft + 2;
                }

                if (middleLeft > nums.length - 3) {
                    left++;
                    middleLeft = left + 1;
                    middleRight = left + 2;
                    right = left + 3;
                }
            }

            return ret;
        }

        public List<List<Integer>> fourSum2(int[] nums, int target) {
            if (nums.length < 4) {
                return null;
            }

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            backTrack(nums, ans, combine, target, 0);
            return ans;
        }

        public void backTrack(int[] nums, List<List<Integer>> ans, List<Integer> combine, int target, int idx) {
            if (idx >= nums.length) {
                return;
            }

            if (combine.stream().mapToInt(x -> x).sum() == target && combine.size() == 4) {
                boolean found = false;
                for (List<Integer> an : ans) {
                    if (an.contains(combine.get(0)) && an.contains(combine.get(1)) &&
                            an.contains(combine.get(2)) && an.contains(combine.get(3))) {
                        found = true;
                    }
                }

                if (!found) {
                    boolean ok = true;
                    if (combine.stream().distinct().count() != 4) {
                        Map<String, Integer> set = valueRepeatCount(combine);
                        List<Integer> numList = new ArrayList<>();
                        for (int num : nums) {
                            numList.add(num);
                        }
                        Map<String, Integer> sourceSet = valueRepeatCount(numList);
                        for (Map.Entry<String, Integer> stringIntegerEntry : set.entrySet()) {
                            if (!sourceSet.get(stringIntegerEntry.getKey()).equals(stringIntegerEntry.getValue())) {
                                ok = false;
                            }
                        }
                    }

                    if (ok) {
                        ans.add(new ArrayList<Integer>(combine));
                    }
                }
                return;
            }

            backTrack(nums, ans, combine, target, idx + 1);


            if (combine.size() < 4) {
                combine.add(nums[idx]);
                backTrack(nums, ans, combine, target, idx);
                combine.remove(combine.size() - 1);
            }
        }

        public Map<String, Integer> valueRepeatCount(List<Integer> list) {
            Map<String, Integer> set = new HashMap<>();
            int val;
            for (Integer integer : list) {
                if (!set.containsKey(integer.toString())) {
                    set.put(integer.toString(), 1);
                } else {
                    val = set.get(integer.toString());
                    set.put(integer.toString(), val + 1);
                }
            }
            return set;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目Id：39;
 * 题目：组合总和，combination-sum;
 * 日期：2021-09-02 13:22:24
 */

//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1506 👎 0


class P_39_CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P_39_CombinationSum().new Solution();
        int[] candidates = {2, 3, 5};
        List<List<Integer>> ret = solution.combinationSum(candidates, 8);
        
        for (List<Integer> integers : ret) {
            for (Integer integer : integers) {
                System.out.printf("%d,", integer);
            }

            System.out.println(" ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length == 0) {
                return null;
            }

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            backTrack(candidates, ans, combine, target, 0);
            return ans;
        }

        public void backTrack(int[] candidates, List<List<Integer>> ans, List<Integer> combine, int target, int idx) {
            if (idx >= candidates.length) {
                return;
            }

            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }

            backTrack(candidates, ans, combine, target, idx + 1);

            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                backTrack(candidates, ans, combine, target - candidates[idx], idx);
                combine.remove(combine.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
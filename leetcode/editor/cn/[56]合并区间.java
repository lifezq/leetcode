package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目Id：56;
 * 题目：合并区间，merge-intervals;
 * 日期：2021-09-17 15:19:09
 */

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1104 👎 0


class P_56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P_56_MergeIntervals().new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = solution.merge(intervals);
        for (int[] an : ans) {
            System.out.printf("%d,%d\n", an[0], an[1]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> merge = new ArrayList<>();
            for (int[] interval : intervals) {
                int left = interval[0];
                int right = interval[1];
                if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < left) {

                    merge.add(new int[]{left, right});
                } else {
                    merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], right);
                }
            }
            return merge.toArray(new int[merge.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
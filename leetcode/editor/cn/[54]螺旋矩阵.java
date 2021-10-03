package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目Id：54;
 * 题目：螺旋矩阵，spiral-matrix;
 * 日期：2021-10-02 22:20:19
 */

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1：
//    1 2 3
//    4 5 6
//    7 8 9
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2：
//    1 2  3  4
//    5 6  7  8
//    9 10 11 12
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 874 👎 0


class P_54_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P_54_SpiralMatrix().new Solution();
        List<Integer> ret = solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for (Integer integer : ret) {
            System.out.printf("%d,", integer);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;


            int beginRow = 0;
            int beginCol = 0;
            List<Integer> ret = new ArrayList<>();

            while (beginRow <= m / 2 && beginCol <= n / 2) {

                int row = beginRow;
                int col = beginCol;

                // 右0,下1,左2,上3
                int flag = 0;
                while (flag <= 3) {
                    switch (flag) {
                        case 0:
                            if (col >= n - col) {
                                return ret;
                            }
                            for (int i = col; i < n - col; i++) {
                                ret.add(matrix[row][i]);
                            }
                            row++;
                            flag = 1;
                            break;
                        case 1:
                            col = n - 1 - col;
                            if (row >= (m - beginRow)) {
                                return ret;
                            }
                            while (row < (m - beginRow)) {
                                ret.add(matrix[row][col]);
                                row++;
                            }
                            row--;
                            col--;
                            flag = 2;
                            break;
                        case 2:
                            if (col < beginCol) {
                                return ret;
                            }
                            while (col >= beginCol) {
                                ret.add(matrix[row][col]);
                                col--;
                            }
                            row--;
                            col++;
                            flag = 3;
                            break;
                        case 3:
                            if (row <= beginRow) {
                                return ret;
                            }
                            while (row > beginRow) {
                                ret.add(matrix[row][col]);
                                row--;
                            }
                            beginRow++;
                            beginCol++;
                            flag = 4;
                            break;
                    }
                }
            }

            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
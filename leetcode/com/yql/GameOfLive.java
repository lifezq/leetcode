package com.yql;

/*
这是一种细胞自动机，每一个位置有两种状态，1为活细胞，0为死细胞，对于每个位置都满足如下的条件：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
如果死细胞周围正好有三个活细胞，则该位置死细胞复活
由于题目中要求我们用置换方法in-place来解题，所以我们就不能新建一个相同大小的数组，那么我们只能更新原有数组，但是题目中要求所有的位置必须被同时更新，但是在循环程序中我们还是一个位置一个位置更新的，那么当一个位置更新了，这个位置成为其他位置的neighbor时，我们怎么知道其未更新的状态呢，我们可以使用状态机转换：

状态0： 死细胞转为死细胞
状态1： 活细胞转为活细胞
状态2： 活细胞转为死细胞
状态3： 死细胞转为活细胞
最后我们对所有状态对2取余，那么状态0和2就变成死细胞，状态1和3就 是活细胞，达成目的。我们先对原数组进行逐个扫描，对于每一个位置，扫描其周围八个位置，如果遇到状态1或2，就计数器累加1，扫完8个邻居，如果少于两个活细胞或者大于三个活细胞，而且当前位置是活细胞的话，标记状态2，如果正好有三个活细胞且当前是死细胞的话，标记状态3。完成一遍扫描后再对数据扫描一遍，对2取余变成我们想要的结果。
复杂度: Time: O(n) ; Space: O(1)
 */
public class GameOfLive {
    public void gameOfLivePlay(int[][] board) {
        if (board.length == 0) {
            return;
        }

        int count;
        int m = board.length, n = board[0].length;
        final int LIVE_TO_LIVE = 2;
        final int DEAD_TO_LIVE = 3;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = liveCount(board, i, j);
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = DEAD_TO_LIVE;
                }

                if (board[i][j] == 1 && count >= 2 && count <= 3) {
                    board[i][j] = LIVE_TO_LIVE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public int liveCount(int[][] board, int currentRow, int currentCol) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int row = Math.max(0, currentRow - 1); row < Math.min(m - 1, currentRow + 1); row++) {
            for (int col = Math.max(0, currentCol - 1); col < Math.min(n - 1, currentCol + 1); col++) {
                if (board[row][col] == 1) {
                    count += board[row][col] & 1;
                }
            }
        }

        return count;
    }
}

package editor.cn;

import java.util.*;

/**
 * 题目Id：103;
 * 题目：二叉树的锯齿形层序遍历，binary-tree-zigzag-level-order-traversal;
 * 日期：2021-09-14 10:22:46
 */

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 517 👎 0


class P_103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P_103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
        Solution.TreeNode node = solution.newTreeNode(3);
        node.left = solution.newTreeNode(9);
        node.right = solution.newTreeNode(20);
        node.right.left = solution.newTreeNode(15);
        node.right.right = solution.newTreeNode(7);
        List<List<Integer>> ans = solution.zigzagLevelOrder(node);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.printf("%d,", integer);
            }

            System.out.println(" ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return null;
            }

            boolean isOrderLeft = true;
            TreeNode node;
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Deque<Integer> levelList = new LinkedList<>();
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    node = q.poll();
                    if (isOrderLeft) {
                        levelList.offerLast(node.val);
                    } else {
                        levelList.offerFirst(node.val);
                    }

                    if (node.left != null) {
                        q.add(node.left);
                    }

                    if (node.right != null) {
                        q.add(node.right);
                    }
                }


                ans.add(new LinkedList<>(levelList));
                isOrderLeft = !isOrderLeft;
            }
            return ans;
        }

        public TreeNode newTreeNode(int val) {
            return new TreeNode(val);
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
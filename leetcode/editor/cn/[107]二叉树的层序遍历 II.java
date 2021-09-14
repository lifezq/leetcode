package editor.cn;

import java.util.*;

/**
 * 题目Id：107;
 * 题目：二叉树的层序遍历 II，binary-tree-level-order-traversal-ii;
 * 日期：2021-09-14 12:27:24
 */

//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
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
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 481 👎 0


class P_107_BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P_107_BinaryTreeLevelOrderTraversalIi().new Solution();
        Solution.TreeNode node = solution.newTreeNode(3);
        node.left = solution.newTreeNode(9);
        node.right = solution.newTreeNode(20);
        node.right.left = solution.newTreeNode(15);
        node.right.right = solution.newTreeNode(7);

        List<List<Integer>> ans = solution.levelOrderBottom(node);
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode node;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            Deque<List<Integer>> ans = new LinkedList<>();
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> levelList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    node = q.poll();
                    levelList.add(node.val);

                    if (node.left != null) {
                        q.add(node.left);
                    }

                    if (node.right != null) {
                        q.add(node.right);
                    }
                }

                ans.addFirst(levelList);
            }

            return new ArrayList<>(ans);
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
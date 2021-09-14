package editor.cn;

/**
 * 题目Id：104;
 * 题目：二叉树的最大深度，maximum-depth-of-binary-tree;
 * 日期：2021-09-14 10:02:02
 */

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 966 👎 0


class P_104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P_104_MaximumDepthOfBinaryTree().new Solution();
        Solution.TreeNode node = solution.newTreeNode(3);
        node.left = solution.newTreeNode(9);
        node.right = solution.newTreeNode(20);
        node.right.left = solution.newTreeNode(15);
        node.right.right = solution.newTreeNode(7);
        System.out.printf("树的深度为：%d\n", solution.maxDepth(node));
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return Math.max(leftHeight, rightHeight) + 1;
            }
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
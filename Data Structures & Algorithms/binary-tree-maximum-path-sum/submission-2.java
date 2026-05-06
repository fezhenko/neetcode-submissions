/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        TreeNode currentRoot = node;
        int maxLeft = Math.max(dfs(currentRoot.left), 0);
        int maxRight = Math.max(dfs(currentRoot.right), 0);
        int currentResult = currentRoot.val + maxLeft + maxRight;
        result = Math.max(currentResult, result);
        return currentRoot.val + Math.max(maxLeft, maxRight);
    }
}

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
    public int goodNodes(TreeNode root) {
        return dfs(root, -101);
    }

    private int dfs(TreeNode root, int prev) {
        if (root == null) return 0;
        return (root.val >= prev ? 1 : 0) +
            dfs(root.left, Math.max(root.val, prev)) +
            dfs(root.right, Math.max(root.val, prev));
    }
}

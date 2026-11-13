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
    public int rob(TreeNode root) {
        final int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(final TreeNode root) {
        if (root == null) return new int[]{0, 0};

        final int[] l = dfs(root.left);
        final int[] r = dfs(root.right);
        
        return new int[]{
            root.val + l[1] + r[1],
            Math.max(l[0], l[1]) + Math.max(r[0], r[1])
        };
    }
}
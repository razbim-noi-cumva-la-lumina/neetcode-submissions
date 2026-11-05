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
    public int maxPathSum(TreeNode root) {
        final int[] d = new int[]{Integer.MIN_VALUE};
        dfs(root, d);
        return d[0];
    }

    private int dfs(final TreeNode root, final int[] d) {
        if (root == null) return 0;
        final int l = Math.max(0, dfs(root.left, d));
        final int r = Math.max(0, dfs(root.right, d));
        d[0] = Math.max(d[0], root.val + l + r);
        return root.val + Math.max(l, r);
    }
}

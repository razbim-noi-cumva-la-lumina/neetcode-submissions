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
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, new int[]{k});
    }

    private int dfs(TreeNode root, int[] k) {
        if (root == null) return -1;

        final int lval = dfs(root.left, k);
        if (lval != -1) return lval;

        --k[0];
        if (k[0] == 0) return root.val;

        return dfs(root.right, k);
    }
}

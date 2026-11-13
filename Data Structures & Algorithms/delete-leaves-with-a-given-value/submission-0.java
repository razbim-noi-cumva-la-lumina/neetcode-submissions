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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        final TreeNode fakeRoot = new TreeNode(0, root, null);
        dfs(fakeRoot, root, target);
        return fakeRoot.left;
    }

    private void dfs(TreeNode prevRoot, TreeNode root, int target) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            dfs(root, root.left, target);
            dfs(root, root.right, target);
        }

        if (root.left == null && root.right == null && root.val == target) {
            if (prevRoot.left == root) prevRoot.left = null;
            else prevRoot.right = null;
        }
    }
}
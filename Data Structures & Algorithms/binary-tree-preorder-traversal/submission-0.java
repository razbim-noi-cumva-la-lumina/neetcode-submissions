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
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> acc = new ArrayList<>();
        dfs(root, acc);
        return acc;
    }

    private void dfs(final TreeNode root, final List<Integer> acc) {
        if (root == null) return;

        acc.add(root.val);
        dfs(root.left, acc);
        dfs(root.right, acc);
    }

}
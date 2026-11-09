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
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> acc = new ArrayList<>();
        dfs(root, acc, 0);
        return acc;
    }

    private void dfs(
        final TreeNode root,
        final List<List<Integer>> acc, 
        final int i
    ) {
        if (root == null) return;
        if (i >= acc.size()) acc.add(new ArrayList<>());
        acc.get(i).add(root.val);
        dfs(root.left, acc, i+1);
        dfs(root.right, acc, i+1);
    }
}

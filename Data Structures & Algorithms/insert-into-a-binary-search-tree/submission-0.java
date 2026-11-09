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
    public TreeNode insertIntoBST(final TreeNode root, int val) {
        TreeNode prev = null, curr = root;
        while (curr != null) {
            prev = curr;
            if (curr.val == val) return root; // shouldn't happen
            if (val < curr.val) curr = curr.left;
            else curr = curr.right;
        }

        if (prev == null) return new TreeNode(val);
        if (prev.left == null && prev.right == null) {
            if (prev.val < val) prev.right = new TreeNode(val);
            else prev.left = new TreeNode(val);
        }
        else if (prev.left == null) prev.left = new TreeNode(val);
        else if (prev.right == null) prev.right = new TreeNode(val);

        return root;
    }
}
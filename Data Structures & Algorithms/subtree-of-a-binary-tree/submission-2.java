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
    public boolean isSubtree(final TreeNode root, final TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        return isSameTree(root, subRoot) ||
            isSubtree(root.left, subRoot) ||
            isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(final TreeNode p, final TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

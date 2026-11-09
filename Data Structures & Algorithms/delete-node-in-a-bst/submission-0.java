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
    public TreeNode deleteNode(final TreeNode root, final int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null) return root.left;
            final TreeNode newRoot = root.right;
            TreeNode curr = root.right;
            while (curr.left != null) curr = curr.left;

            curr.left = root.left;
            return newRoot;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}
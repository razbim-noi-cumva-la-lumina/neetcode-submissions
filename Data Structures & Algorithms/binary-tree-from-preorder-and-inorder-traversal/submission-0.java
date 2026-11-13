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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) m.put(inorder[i], i);
        return dfs(
            m,
            preorder, 0, preorder.length - 1,
            inorder, 0, preorder.length - 1
        );
    }

    private TreeNode dfs(
        final Map<Integer, Integer> m,
        final int[] preorder, int pl, int pr,
        final int[] inorder, int il, int ir
    ) {
        if (pl > pr) return null;

        final int val = preorder[pl];
        final TreeNode root = new TreeNode(val);
        if (pl == pr) return root;

        final int pivot = m.get(val);
        final int leftSize = pivot - il;
        
        root.left = dfs(m, preorder, pl+1, pl+leftSize, inorder, il, pivot-1);
        root.right = dfs(m, preorder, pl+leftSize+1, pr, inorder, pivot+1, ir);
        return root;
    }
}

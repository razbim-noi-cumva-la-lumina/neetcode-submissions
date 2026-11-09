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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        final List<Integer> res = new ArrayList<>(16);
        final Queue<TreeNode> q = new ArrayDeque<>(16);
        q.add(root);

        while (!q.isEmpty()) {
            final int len = q.size();
            for (int i = 0; i < len; ++i) {
                final TreeNode cur = q.remove();
                if (i == 0) res.add(cur.val);
                if (cur.right != null) q.add(cur.right);
                if (cur.left != null) q.add(cur.left);
            }
        }

        return res;
    }
}

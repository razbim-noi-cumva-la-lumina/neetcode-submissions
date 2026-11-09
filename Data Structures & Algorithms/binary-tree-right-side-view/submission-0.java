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

        final List<List<Integer>> acc = new ArrayList<>();
        final Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            final int len = q.size();
            final List<Integer> lev = new ArrayList<>();
            for (int i = 0; i < len; ++i) {
                final TreeNode cur = q.remove();
                lev.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

            acc.add(lev);
        }

        final List<Integer> res = new ArrayList<>(acc.size());
        for (final List<Integer> lev : acc)
            res.add(lev.get(lev.size() - 1));

        return res;
    }
}

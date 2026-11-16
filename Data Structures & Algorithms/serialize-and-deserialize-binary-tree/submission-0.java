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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(final TreeNode root) {
        if (root == null) return "";

        final List<String> sb = new ArrayList<>();
        final Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.empty()) {
            final TreeNode curr = s.pop();
            if (curr == null) {
                sb.add("N");
                continue;
            }
            sb.add(Integer.toString(curr.val));
            s.push(curr.right);
            s.push(curr.left);
        }

        return String.join(",", sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        System.out.println(Arrays.toString(data.split(",")));
        return buildTree(data.split(","), new int[]{0});
    }

    private TreeNode buildTree(final String[] vals, final int[] idx) {
        if (idx[0] >= vals.length) return null;
        if (vals[idx[0]].equals("N")) {
            ++idx[0];
            return null;
        }

        return new TreeNode(
            Integer.parseInt(vals[idx[0]++]),
            buildTree(vals, idx),
            buildTree(vals, idx)
        );
    }
}

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(final int[][] grid) {
        return dei(grid, 0, 0, grid.length);
    }

    private Node dei(final int[][] grid, final int r, final int c, final int len) {
        if (len == 1) return new Node(grid[r][c] == 1, true, null, null, null, null) ;

        final int hlen = len / 2;
        final Node topLeft = dei(grid, r, c, hlen),
            topRight = dei(grid, r, c + hlen, hlen),
            bottomLeft = dei(grid, r + hlen, c, hlen),
            bottomRight = dei(grid, r + hlen, c + hlen, hlen);

        if (
            topLeft.isLeaf &&
            topRight.isLeaf &&
            bottomLeft.isLeaf &&
            bottomRight.isLeaf &&
            topLeft.val == topRight.val &&
            topLeft.val == bottomLeft.val &&
            topLeft.val == bottomRight.val
        ) {
            return topLeft;
        }

        return new Node(
            false,
            false,
            topLeft,
            topRight,
            bottomLeft,
            bottomRight
        );
    }
}
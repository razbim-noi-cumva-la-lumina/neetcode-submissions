class Solution {
    public int[][] candyCrush(final int[][] board) {
        final int m = board.length, n = board[0].length;

        while (true) {
            boolean hasCrush = false;
            for (int r = 0; r < m; ++r) {
                for (int c = 0; c < n; ++c) {
                    if (board[r][c] == 0) continue;
                    final boolean res1 = setRowWise(board, r, c);
                    final boolean res2 = setColWise(board, r, c);
                    hasCrush = hasCrush || res1 || res2;
                }
            }

            if (!hasCrush) break;

            for (int r = 0; r < m; ++r)
                for (int c = 0; c < n; ++c)
                    if (board[r][c] < 0) board[r][c] = 0;

            for (int c = 0; c < n; ++c) {
                int zeroIdx = m - 1;
                for (; zeroIdx >= 0; --zeroIdx) if (board[zeroIdx][c] == 0) break;
                for (int r = zeroIdx - 1; r >= 0; --r) {
                    board[zeroIdx][c] = board[r][c];
                    if (board[zeroIdx][c] != 0) --zeroIdx;
                    if (board[r][c] != 0) board[r][c] = 0;
                }
            }
        }

        return board;
    }

    private boolean setRowWise(final int[][] board, final int r, final int c) {
        if (r + 2 < board.length) {
            final int v = Math.abs(board[r][c]);
            if (v == Math.abs(board[r+1][c]) && v == Math.abs(board[r+2][c])) {
                final int nv = neg(v);
                board[r][c] = nv;
                board[r+1][c] = nv;
                board[r+2][c] = nv;
                return true;
            }
        }
        return false;
    }

    private boolean setColWise(final int[][] board, final int r, final int c) {
        if (c + 2 < board[0].length) {
            final int v = Math.abs(board[r][c]);
            if (v == Math.abs(board[r][c+1]) && v == Math.abs(board[r][c+2])) {
                final int nv = neg(v);
                board[r][c] = nv;
                board[r][c+1] = nv;
                board[r][c+2] = nv;
                return true;
            }
        }
        return false;
    }

    private int neg(final int n) {
        return n < 0 ? n : -n;
    }
}

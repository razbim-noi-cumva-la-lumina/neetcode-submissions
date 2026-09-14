class TicTacToe {
    final int[][] board;

    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;

        boolean ok = true;
        for (int r = 0; ok && r < board.length; ++r)
            if (board[r][col] != player) ok = false;
        if (ok) return player;

        ok = true;
        for (int c = 0; ok && c < board.length; ++c)
            if (board[row][c] != player) ok = false;
        if (ok) return player;

        if (row == col) {
            ok = true;
            for (int x = 0; x < board.length; ++x)
                if (board[x][x] != player) ok = false;
            if (ok) return player;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

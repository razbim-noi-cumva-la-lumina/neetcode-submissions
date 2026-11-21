class Solution {
    static int[][] DIR = new int[][]{{1,0}, {-1,0}, {0,1}, {0, -1}};

    static class Node {
        String word = null;
        Node[] next = new Node[26];
    }

    public List<String> findWords(final char[][] board, final String[] words) {
        final Node trie = makeTrie(words);
        final List<String> acc = new ArrayList<>();
        for (int r = 0; r < board.length; ++r)
            for (int c = 0; c < board[0].length; ++c)
                dfs(acc, board, r, c, trie);

        return acc;
    }

    private void dfs(
        final List<String> acc,
        final char[][] board,
        final int r, final int c,
        Node curr
    ) {
        if (Math.min(r, c) < 0 || r >= board.length || c >= board[0].length) return;
        if (curr == null || board[r][c] == '#') return;

        final char chr = board[r][c];
        final int i = chr - 'a';
        if (curr.next[i] == null)
            return;
        
        curr = curr.next[i];
        if (curr.word != null) {
            acc.add(curr.word);
            curr.word = null;
        }

        board[r][c] = '#';
        for (final int[] dir : DIR)
            dfs(acc, board, r+dir[0], c+dir[1], curr);

        board[r][c] = chr;
    }

    private Node makeTrie(final String[] words) {
        final Node root = new Node();
        for (final String word : words) {
            Node curr = root;
            for (final char c : word.toCharArray()) {
                final int i = c - 'a';
                if (curr.next[i] == null)
                    curr.next[i] = new Node();
                curr = curr.next[i];
            }

            curr.word = word;
        }
        return root;
    }
}

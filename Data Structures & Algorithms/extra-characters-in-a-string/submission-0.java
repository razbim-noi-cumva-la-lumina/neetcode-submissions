class Solution {
    static class Node {
        boolean isWord = false;
        Node[] next = new Node[26];
    }
    
    public int minExtraChar(final String s, final String[] dictionary) {
        final Node root = new Node();
        for (final String word : dictionary) {
            Node curr = root;
            for (final char c : word.toCharArray()) {
                final int i = c - 'a';
                if (curr.next[i] == null) {
                    curr.next[i] = new Node();
                }
                curr = curr.next[i];
            }
            curr.isWord = true;
        }

        final int[] dp = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; --i) {
            dp[i] = dp[i+1]+1;
            Node curr = root;
            for (int j = i; j < s.length(); ++j) {
                final int idx = s.charAt(j) - 'a';
                if (curr.next[idx] == null) break;
                curr = curr.next[idx];
                if (curr.isWord)
                    dp[i] = Math.min(dp[i], dp[j+1]);
            }
        }
        return dp[0];
    }
}
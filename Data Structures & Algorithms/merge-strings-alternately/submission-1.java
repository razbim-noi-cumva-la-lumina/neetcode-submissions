class Solution {
    public String mergeAlternately(final String word1, final String word2) {
        final StringBuilder bob = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (bob.length() % 2 == 0) {
                bob.append(word1.charAt(i++));
            } else {
                bob.append(word2.charAt(j++));
            }
        }
        drain(bob, word1, i);
        drain(bob, word2, j);
        return bob.toString();
    }

    private void drain(final StringBuilder bob, final String s, int i) {
        while (i < s.length())
            bob.append(s.charAt(i++));
    }
}
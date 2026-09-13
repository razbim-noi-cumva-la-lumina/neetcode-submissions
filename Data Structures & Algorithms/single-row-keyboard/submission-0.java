class Solution {
    public int calculateTime(final String keyboard, final String word) {
        final int[] map = new int[26];
        for (int i = 0; i < 26; ++i)
            map[keyboard.charAt(i) - 'a'] = i;

        int t = 0;
        int u = 0;
        for (final char c : word.toCharArray()) {
            final int v = map[c - 'a'];
            t += Math.abs(u - v);
            u = v;
        }
        return t;
    }
}

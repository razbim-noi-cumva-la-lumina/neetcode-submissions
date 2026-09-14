class Solution {
    public boolean isOneEditDistance(final String s, final String t) {
        final int n = 62;
        final int[] fs = new int[n], ft = new int[n];
        for (final char c : s.toCharArray())
            ++fs[chr(c)];
        for (final char c : t.toCharArray())
            ++ft[chr(c)];
        
        int diff = 0;
        for (int i = 0; i < n; ++i)
            diff += Math.abs(fs[i] - ft[i]);

        return diff == 1;
    }

    final int chr(final char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return (c - 'A') + 26;
        return (c - '0') + 52;
    }
}

class Solution {
    public boolean isAnagram(final String s, final String t) {
        final int[] f = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            f[s.charAt(i) - 'a'] ++;
            f[t.charAt(i) - 'a'] --;
        }

        for (final int num : f) {
            if (num != 0) return false;
        }

        return true;
    }
}

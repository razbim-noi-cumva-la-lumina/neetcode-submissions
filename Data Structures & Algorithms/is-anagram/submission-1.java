class Solution {
    public boolean isAnagram(final String s, final String t) {
        final int[] f = new int[26];
        for (final char c : s.toCharArray()) f[c - 'a']++;
        for (final char c : t.toCharArray()) f[c - 'a']--;

        for (final int num : f) {
            if (num != 0) return false;
        }

        return true;
    }
}

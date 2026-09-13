class Solution {
    public boolean isSubsequence(final String s, final String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            for (; j < t.length(); ++j) {
                if (s.charAt(i) == t.charAt(j)) {
                    ++i;
                    break;
                }
            }
            ++j;
        }

        return i == s.length();
    }
}
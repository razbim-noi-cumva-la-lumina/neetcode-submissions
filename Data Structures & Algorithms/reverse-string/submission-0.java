class Solution {
    public void reverseString(final char[] s) {
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            final char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
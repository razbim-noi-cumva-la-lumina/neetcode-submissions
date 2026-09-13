class Solution {
    public void reverseWords(final char[] s) {
        swapView(s, 0, s.length - 1);
        int l = 0, r = 0;
        while (r < s.length) {
            if (s[r] == ' ') {
                swapView(s, l, r - 1);
                l = r + 1;
            }
            ++r;
        }

        swapView(s, l, r - 1);
    }

    private void swapView(final char[] s, int l, int r) {
        while (l < r) {
            final char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}

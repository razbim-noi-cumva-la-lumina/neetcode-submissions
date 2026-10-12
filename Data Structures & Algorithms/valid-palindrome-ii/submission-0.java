class Solution {
    public boolean validPalindrome(final String s) {
        return palindromeInRange(s, 0, s.length() - 1, false);
    }

    private boolean palindromeInRange(final String s, int l, int r, boolean didDelete) {
        for (; l < r; ++l, --r)
            if (s.charAt(l) != s.charAt(r)) {
                if (didDelete)  return false;
                return palindromeInRange(s, l+1, r, true) ||
                       palindromeInRange(s, l, r-1, true);
            }
        return true;
    }
}
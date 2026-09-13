class Solution {
    public boolean canPermutePalindrome(final String s) {
        final int[] f = new int[26];
        for (final char c : s.toCharArray()) 
            ++f[c - 'a'];

        boolean hasOdd = false;
        for (final int num : f) {
            if (num % 2 == 1) {
                if (hasOdd) return false;
                hasOdd = true;
            }
        }

        return true;
    }
}

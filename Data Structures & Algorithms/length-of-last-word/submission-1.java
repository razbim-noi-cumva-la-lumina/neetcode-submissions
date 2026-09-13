class Solution {
    public int lengthOfLastWord(final String s) {
        boolean gotNonSpace = false;
        int len = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                ++len;
                gotNonSpace = true;
            } else {
                if (gotNonSpace) return len;
            }
        }

        return len;
    }
}
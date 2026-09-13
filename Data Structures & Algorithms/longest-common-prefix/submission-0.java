class Solution {
    public String longestCommonPrefix(final String[] strs) {
        final char[] prefix = strs[0].toCharArray();
        int r = prefix.length;
        for (int i = 1; i < strs.length; ++i) {
            final String w = strs[i];
            int j = 0;
            while (j < r && j < w.length()) {
                if (prefix[j] != w.charAt(j)) {
                    break;
                }
                ++j;
            }
            r = j;
            if (r == 0) break;
        }

        return new String(prefix, 0, r);
    }
}
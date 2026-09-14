class Solution {
    public int findLonelyPixel(final char[][] picture) {
        final int m = picture.length, n = picture[0].length;

        final int[] rows = new int[n], cols = new int[m];
        for (int r = 0; r < m; ++r) {
            int colCnt = 0;
            for (int c = 0; c < n; ++c) {
                if (picture[r][c] == 'B') {
                    ++rows[c]; 
                    ++colCnt;
                }
            }

            cols[r] = colCnt;
        }

        int res = 0;
        for (int i = 0; i < Math.min(m, n); ++i)
            if (cols[i] == 1 && rows[i] == 1)
                ++res;

        return res;
    }
}

class Solution {
    public int findLonelyPixel(final char[][] picture) {
        final int m = picture.length, n = picture[0].length;

        final int[] rowCnts = new int[m], colCnts = new int[n];
        for (int r = 0; r < m; ++r) {
            int rowCnt = 0;
            for (int c = 0; c < n; ++c) {
                if (picture[r][c] == 'B') {
                    ++colCnts[c]; 
                    ++rowCnt;
                }
            }

            rowCnts[r] = rowCnt;
        }

        int res = 0;
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (picture[r][c] == 'B' && rowCnts[r] == 1 && colCnts[c] == 1)
                    ++res;

        return res;
    }
}

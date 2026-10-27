class Solution {
    public int mySqrt(final int x) {
        int l = 0, r = x, res = 0;
        while (l <= r) {
            final int m = l + (r - l) / 2;
            final long m2 = (long) m * m;
            if (m2 <= x) {
                l = m + 1;
                res = m;
            } else r = m - 1;
        }

        return res;
    }
}
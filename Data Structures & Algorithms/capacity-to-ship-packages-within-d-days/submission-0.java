class Solution {
    public int shipWithinDays(final int[] weights, final int days) {
        int l = -1, r = 0;
        for (final int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        while (l < r) {
            final int m = l + (r - l) / 2;
            int d = 1, sum = 0;
            for (final int w : weights) {
                if (sum + w > m) {
                    ++d;
                    sum = 0;
                }
                sum += w;
            }
            

            if (d > days) l = m + 1;
            else r = m;
        }

        return l;
    }
}
class Solution {
    public int minEatingSpeed(final int[] piles, final int h) {
        int l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            final int k = l + (r - l) / 2;
            int sum = 0;
            for (final int pile : piles)
                sum = sum + (pile + k - 1) / k;

            if (sum <= h) r = k;
            else l = k + 1;
        }

        return l;
    }
}

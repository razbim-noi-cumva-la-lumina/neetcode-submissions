class Solution {
    public int largestUniqueNumber(final int[] nums) {
        final int[] f = new int[1001];
        for (final int num : nums) ++f[num];

        for (int i = 1000; i >= 0; --i)
            if (f[i] % 2 == 1)
                return i;

        return -1;
    }
}

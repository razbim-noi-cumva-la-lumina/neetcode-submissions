class Solution {
    public List<Integer> findClosestElements(final int[] nums, final int k, final int x) {
        int l = 0, r = nums.length - k;
        while (l < r) {
            final int m = l + (r - l) / 2;
            final int ldiff = x - nums[m];
            final int rdiff = nums[m + k] - x;
            if (ldiff > rdiff) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        final List<Integer> res = new ArrayList<>();
        for (final int to = l + k; l < to; ++l)
            res.add(nums[l]);
        return res;
    }
}

/*

2 4 5 8
l r

4     2

*/
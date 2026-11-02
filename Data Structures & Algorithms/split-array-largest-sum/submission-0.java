class Solution {
    public int splitArray(final int[] nums, final int k) {
        int l = -1, r = 0;
        for (final int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        while (l < r) {
            final int m = l + (r - l) / 2;

            int sum = 0, cnt = 1;
            for (int i = 0; i < nums.length; ++i) {
                if (sum + nums[i] > m) {
                    ++cnt;
                    sum = 0;
                }

                sum += nums[i];
            }
            
            if (cnt > k) l = m + 1;
            else r = m;
        }

        return l;
    }
}
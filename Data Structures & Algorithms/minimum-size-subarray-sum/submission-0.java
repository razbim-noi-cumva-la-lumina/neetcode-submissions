class Solution {
    public int minSubArrayLen(final int target, final int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int l = 0, r = 0; r < nums.length; ++r) {
            sum += nums[r];
            while (sum >= target) {
                final int len = r - l + 1;
                res = Math.min(res, len);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
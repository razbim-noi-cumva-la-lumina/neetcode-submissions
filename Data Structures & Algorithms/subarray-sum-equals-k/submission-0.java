class Solution {
    public int subarraySum(final int[] nums, final int k) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            long sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == k) ++count;
            }
        }
        return count;
    }
}
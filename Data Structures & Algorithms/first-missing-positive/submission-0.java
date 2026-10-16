class Solution {
    public int firstMissingPositive(final int[] nums) {
        final int defaultValue = nums.length + 2;
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] <= 0) nums[i] = defaultValue;

        for (int i = 0; i < nums.length; ++i) {
            final int it = Math.abs(nums[i]) - 1;
            if (it >= 0 && it < nums.length && nums[it] > 0)
                nums[it] *= -1;
        }

        for (int i = 1; i <= nums.length; ++i)
            if (nums[i - 1] > 0) return i;

        return nums.length + 1;
    }
}
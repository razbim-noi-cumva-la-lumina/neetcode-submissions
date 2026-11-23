class Solution {
    public int subsetXORSum(final int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(final int[] nums, int i, int xor) {
        int sum = 0;
        for (int j = i; j < nums.length; ++j) {
            xor = xor ^ nums[j];
            sum = sum + xor + dfs(nums, j+1, xor);
            xor = xor ^ nums[j];
        }
        return sum;
    }
}
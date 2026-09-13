class Solution {
    public int removeElement(final int[] nums, final int val) {
        int res = nums.length;
        for (int i = 0; i < res; ++i)
            while (i < res && nums[i] == val)
                nums[i] = nums[--res];

        return res;
    }
}
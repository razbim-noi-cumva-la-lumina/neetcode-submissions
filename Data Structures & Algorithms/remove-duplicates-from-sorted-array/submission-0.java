class Solution {
    public int removeDuplicates(final int[] nums) {
        int n = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[n-1] != nums[i])
                nums[n++] = nums[i];
        }

        return n;
    }
}

/*

[2, 10, 10, 30, 30, 30]

[2, 10, 30]

*/
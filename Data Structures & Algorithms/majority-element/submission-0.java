class Solution {
    public int majorityElement(final int[] nums) {
        int num = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == num) {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    num = nums[i];
                    cnt = 1;
                }
            }
        }

        return num;
    }
}
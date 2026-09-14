class Solution {
    public void sortColors(final int[] nums) {
        int r=0, w=0, b=0;
        for (final int num : nums)
            switch (num) {
                case 0: ++r; break;
                case 1: ++w; break;
                case 2: ++b; break;
            }

        for (int i = 0; i < nums.length; ++i) {
            if (r > 0) {nums[i] = 0; --r;}
            else if (w > 0) {nums[i] = 1; --w;}
            else if (b > 0) {nums[i] = 2; --b;}
        }
    }
}
class Solution {
    public int search(final int[] nums, final int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            final int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m+1;
            else r = m;
        }

        if (target == nums[l]) return l;

        if (nums[l] < target && target <= nums[nums.length-1]) {
            r = nums.length;
        } else {
            r = l;
            l = 0;
        }

        while (l <= r) {
            final int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[m] < target) l = m+1;
            else r = m-1;
        }

        return -1;
    }
}

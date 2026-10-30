class Solution {
    public boolean search(final int[] nums, final int target) {
        int l = 0, r = nums.length - 1;

        while (l < r && nums[l] == nums[r]) --r;
        final int end = r;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        final int pivot = l;

        if (target >= nums[pivot] && target <= nums[end]) {
            l = pivot; r = end;
        } else {
            l = 0; r = pivot - 1;
        }

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}
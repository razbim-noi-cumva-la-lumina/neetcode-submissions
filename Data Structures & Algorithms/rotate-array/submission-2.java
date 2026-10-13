class Solution {
    public void rotate(final int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return; 

        for (int start = 0, moved = 0; moved < nums.length; ++start) {
            int prev = nums[start];
            int j = start;
            do {
                j = (j + k) % nums.length;
                final int tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
                ++moved;
            } while (j != start);
        }
    }
}

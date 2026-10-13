class Solution {
    public void rotate(final int[] nums, final int k) {
        final int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            final int j = (i + k) % nums.length;
            res[j] = nums[i];
        }
        for (int i = 0; i < nums.length; ++i)
            nums[i] = res[i];
    }
}

/*

1, 2, 3, 4, 5, 6, 7  /  3

         1        4
      7        3.
   6        2
5


        k = k % nums.length;
        for (int i = 0; i < k; ++i) {
            int prev = nums[i];
            int j = i + k;
            while (i != j) {
                if (j >= nums.length) {
                    didWrap = true;
                    j = j % nums.length;
                }

                final int tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
                j += k;
            }
        }
    

*/
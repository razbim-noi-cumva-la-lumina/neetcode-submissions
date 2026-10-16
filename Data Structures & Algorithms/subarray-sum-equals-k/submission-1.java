class Solution {
    public int subarraySum(final int[] nums, final int k) {
        final Map<Long, Integer> m = new HashMap<>();
        m.put(0L, 1);

        long sum = 0L;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            final long diff = sum - k;

            count += m.getOrDefault(diff, 0);
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
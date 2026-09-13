class Solution {
    public boolean hasDuplicate(final int[] nums) {
        final Set<Integer> s = new HashSet<>();
        for (final int num : nums) {
            if (s.contains(num)) return true;
            s.add(num);
        }

        return false;
    }
}
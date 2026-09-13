class Solution {
    public int[] anagramMappings(final int[] nums1, final int[] nums2) {
        final Map<Integer, Stack<Integer>> idxm = new HashMap<>();
        for (int i = 0; i < nums2.length; ++i) {
            Stack<Integer> s = idxm.get(nums2[i]);
            if (s == null) {
                s = new Stack<>();
                idxm.put(nums2[i], s);
            }

            s.push(i);
        }

        final int[] map = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            map[i] = idxm.get(nums1[i]).pop();
        }
        return map;
    }
}

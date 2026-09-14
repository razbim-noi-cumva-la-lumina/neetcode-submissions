class Solution {
    public int maxDistance(final List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE,
            max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (final List<Integer> arr : arrays) {
            min2 = Math.min(min2, min1);
            min1 = Math.min(arr.get(0), min1);

            max2 = Math.max(max2, max1);
            max1 = Math.max(arr.get(arr.size() - 1), max1);
        }

        return Math.max(
            Math.abs(max2 - min1),
            Math.abs(max1 - min2)
        );
        
    }
}

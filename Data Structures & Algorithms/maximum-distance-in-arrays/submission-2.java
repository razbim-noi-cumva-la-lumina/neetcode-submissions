class Solution {
    public int maxDistance(final List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE,
            max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (final List<Integer> arr : arrays) {
            final int first = arr.get(0),
                      last = arr.get(arr.size() - 1);

            if (first < min1) {
                min2 = min1;
                min1 = first;
            } else if (first < min2) {
                min2 = first;
            }

            if (last > max1) {
                max2 = max1;
                max1 = last;
            } else if (last > max2) {
                max2 = last;
            }
        }

        return Math.max(
            Math.abs(max2 - min1),
            Math.abs(max1 - min2)
        );
        
    }
}

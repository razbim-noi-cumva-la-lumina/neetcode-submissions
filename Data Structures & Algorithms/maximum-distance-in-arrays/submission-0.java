class Solution {
    public int maxDistance(final List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (final List<Integer> arr : arrays) {
            min = Math.min(arr.get(0), min);
            max = Math.max(arr.get(arr.size() - 1), max);
        }
        return Math.abs(max - min);
    }
}

class Solution {
    public int maxDistance(final List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1), res = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); ++i) {
            final List<Integer> arr = arrays.get(i);
            final int curr_min = arr.get(0), curr_max = arr.get(arr.size() - 1);
            res = Math.max(
                res,
                Math.max(Math.abs(max - curr_min), Math.abs(curr_max - min))
            );
            min = Math.min(min, curr_min);
            max = Math.max(max, curr_max);
        }
        
        return res;
    }
}

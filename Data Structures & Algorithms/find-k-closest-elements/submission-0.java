class Solution {
    public List<Integer> findClosestElements(
        final int[] arr,
        final int k,
        final int x) {

        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            final int cmp = Integer.compare(a[0], b[0]);
            if (cmp == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return cmp;
        });
        for (final int num : arr) pq.add(new int[]{Math.abs(num - x), num});

        final List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) res.add(pq.remove()[1]);
        Collections.sort(res);
        return res;
    }
}
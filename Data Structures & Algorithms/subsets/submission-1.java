class Solution {
    public List<List<Integer>> subsets(final int[] nums) {
        final List<List<Integer>> acc = new ArrayList<>();
        dfs(acc, new ArrayList<>(), nums, 0);
        return acc;
    }

    private void dfs(final List<List<Integer>> acc, final List<Integer> cur, final int[] nums, int i) {
        acc.add(new ArrayList<>(cur));
        for (int j = i; j < nums.length; ++j) {
            cur.add(nums[j]);
            dfs(acc, cur, nums, j+1);
            cur.remove(cur.size()-1);
        }
    }
}

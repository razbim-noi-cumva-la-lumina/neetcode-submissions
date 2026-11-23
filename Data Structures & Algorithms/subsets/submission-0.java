class Solution {
    public List<List<Integer>> subsets(final int[] nums) {
        final List<List<Integer>> acc = new ArrayList<>();
        dfs(acc, new ArrayList<>(), nums, 0);
        return acc;
    }

    private void dfs(final List<List<Integer>> acc, final List<Integer> cur, final int[] nums, int i) {
        if (i == nums.length) {
            acc.add(new ArrayList<>(cur));
            return;
        }

        dfs(acc, cur, nums, i+1);
        cur.add(nums[i]);
        dfs(acc, cur, nums, i+1);
        cur.remove(cur.size()-1);
    }
}

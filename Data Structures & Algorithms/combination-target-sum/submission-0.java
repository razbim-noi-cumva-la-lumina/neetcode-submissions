class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        final List<List<Integer>> acc = new ArrayList<>();
        dfs(acc, new ArrayList<>(), nums, 0, target);
        return acc;
    }

    private void dfs(final List<List<Integer>> acc, final List<Integer> cur, final int[] nums, int i, int target) {
        if (target == 0) {
            acc.add(new ArrayList<>(cur));
            return;
        }
        if (i >= nums.length || target < 0) return;

        cur.add(nums[i]);
        dfs(acc, cur, nums, i, target - nums[i]);

        cur.remove(cur.size()-1);
        dfs(acc, cur, nums, i+1, target);
    }
}

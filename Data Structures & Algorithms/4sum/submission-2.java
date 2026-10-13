class Solution {
    public List<List<Integer>> fourSum(final int[] nums, final int target) {
        final List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);

        kSum(res, new ArrayList<>(), nums, 4, target, 0);
        return res;
    }

    private void kSum(
        final List<List<Integer>> res, final List<Integer> acc,
        final int[] nums, final int k, final int target, final int start
    ) {
        if (k > 2) {
            for (int i = start; i < nums.length - k + 1; ++i) {
                if (i > start && nums[i] == nums[i-1]) continue;
                if (target < 0 && nums[i] > 0) continue;

                acc.add(nums[i]);
                kSum(res, acc, nums, k - 1, target - nums[i], i + 1);
                acc.remove(acc.size() - 1);
            }
            return;
        }

        int l = start, r = nums.length - 1;
        while (l < r) {
            final int sum = nums[l] + nums[r];
            if (sum == target) {
                final List<Integer> newAcc = new ArrayList<>(acc);
                newAcc.add(nums[l]);
                newAcc.add(nums[r]);
                res.add(newAcc);

                l++;
                while (l < r && nums[l] == nums[l-1]) ++l;
                continue;
            } else if (sum < target) {
                ++l;
            } else {
                --r;
            }
        }
    }
}

/**
[-3,0,1,2,3,3]

 ^          ^ 
*/
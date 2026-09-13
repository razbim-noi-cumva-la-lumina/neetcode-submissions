class FirstUnique {
    private final Map<Integer, Integer> cnts = new HashMap<>();
    private final Queue<Integer> q = new LinkedList<>();

    public FirstUnique(final int[] nums) {
        for (final int num : nums)
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);

        for (final int num : nums)
            if (cnts.get(num) == 1)
                q.add(num);
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty()) {
            final int num = q.peek();
            if (cnts.getOrDefault(num, 0) == 1)
                return num;
            q.remove();
        }

        return -1;
    }
    
    public void add(int value) {
        cnts.put(value, cnts.getOrDefault(value, 0) + 1);
        q.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

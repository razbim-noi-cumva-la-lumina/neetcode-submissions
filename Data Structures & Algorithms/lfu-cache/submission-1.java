class LFUCache {
    private final Map<Integer, int[]> m = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> lfu = new HashMap<>();
    private final int cap;
    private int min = -1;

    public LFUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(final int key) {
        final int[] tup = m.get(key);
        if (tup == null) return -1;

        final int val = tup[0], freq = tup[1];
        final LinkedHashSet<Integer> set = lfu.get(freq);
        set.remove(key);
        if (freq == min && set.size() == 0) ++min;

        putFreq(key, freq+1);
        tup[1] += 1;
        return val;
    }
    
    public void put(final int key, final int val) {
        if (cap == 0) return;

        final int[] tup = m.get(key);
        if (tup != null) {
            m.put(key, new int[]{val, tup[1]});
            get(key);
            return;
        }

        if (m.size() == cap) {
            final LinkedHashSet<Integer> set = lfu.get(min);
            final int keyToRemove = set.iterator().next();
            set.remove(keyToRemove);
            m.remove(keyToRemove);
        }

        min = 1;
        m.put(key, new int[]{val, min});
        putFreq(key, min);
    }

    private void putFreq(final int key, final int freq) {
        LinkedHashSet<Integer> set = lfu.get(freq);
        if (set == null) set = new LinkedHashSet<>();
        set.add(key);
        lfu.put(freq, set);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
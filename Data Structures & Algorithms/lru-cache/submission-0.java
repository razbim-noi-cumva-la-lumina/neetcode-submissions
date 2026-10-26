class LRUCache {
    static class Node {
        int key, val;
        Node prev, next;
    }

    private final Node[] pool;
    private int used = 0;
    private final Map<Integer, Node> m;
    private final Node top = new Node();
    private final Node bot = new Node();

    public LRUCache(int capacity) {
        pool = new Node[capacity];
        for (int i = 0; i < capacity; ++i) pool[i] = new Node();
        m = new HashMap<>(capacity * 2);
        top.next = bot;
        bot.prev = top;
    }

    public int get(int key) {
        final Node n = m.get(key);
        if (n == null) return -1;
        unlink(n);
        pushTop(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node n = m.get(key);
        if (n != null) {
            n.val = value;
            unlink(n);
            pushTop(n);
            return;
        }

        if (used < pool.length) {
            n = pool[used++];
        } else {
            n = bot.prev;
            unlink(n);
            m.remove(n.key);
        }

        n.key = key;
        n.val = value;
        m.put(key, n);
        pushTop(n);
    }

    private void unlink(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void pushTop(Node n) {
        n.next = top.next;
        n.prev = top;
        top.next.prev = n;
        top.next = n;
    }
}
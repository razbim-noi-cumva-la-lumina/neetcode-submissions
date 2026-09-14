class MyHashMap {
    class Node {
        public int key;
        public int val;
        public Node next;
        public Node(final int key, final int val, final Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private static final int N = 10_000;
    private Node[] data = new Node[N];
    
    public void put(int key, int value) {
        final int i = key % N;
        Node curr = data[i];
        if (curr == null) {
            data[i] = new Node(key, value, null);
            return;
        }

        while (curr.next != null && curr.key != key) curr = curr.next;
        if (curr.key == key) curr.val = value;
        else curr.next = new Node(key, value, null);
    }
    
    public int get(int key) {
        final int i = key % N;
        Node curr = data[i];
        while (curr != null && curr.key != key) curr = curr.next;
        return curr == null ? -1 : curr.val;
    }
    
    public void remove(int key) {
        final int i = key % N;
        Node prev = null, curr = data[i];
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) return;
        if (prev == null) data[i] = curr.next;
        else prev.next = curr.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
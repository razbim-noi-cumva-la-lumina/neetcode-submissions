class MyHashSet {
    private static final int N = 10_000;
    class Node {
        public int value;
        public Node next;
        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    private Node[] data = new Node[N];

    public void add(final int key) {
        final int idx = key % N;
        if (data[idx] == null) {
            data[idx] = new Node(key, null);
        } else {
            Node curr = data[idx];
            while (curr.next != null) {
                if (curr.value == key) return;
                curr = curr.next;
            }
            if (curr.value != key) curr.next = new Node(key, null);
        }
    }

    public void remove(final int key) {
        final int idx = key % N;
        Node prev = null, curr = data[idx];
        while (curr != null && curr.value != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            if (prev == null) data[idx] = curr.next;
            else prev.next = curr.next;
        }
    }

    public boolean contains(final int key) {
        final int idx = key % N;
        Node curr = data[idx];
        while (curr != null) {
            if (curr.value == key) return true;
            curr = curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
class PrefixTree {
    static class Node {
        char c;
        boolean isWord;
        boolean isLeaf;
        Node[] next;
        public Node(char c) {
            this.c = c;
            this.isLeaf = true;
            this.next = new Node[26];
        }
        public String toString() { return "Node{"+c+"}";}
    }

    private Node root;

    public PrefixTree() {
        root = new Node('/');
    }

    public void insert(String word) {
        Node curr = root;
        for (final char c : word.toCharArray()) {
            final int i = c - 'a';
            if (curr.next[i] == null) {
                final Node next = new Node(c);
                curr.next[i] = next;
            }
            curr.isLeaf = false;
            curr = curr.next[i];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (final char c : word.toCharArray()) {
            if (curr == null || curr.isLeaf) {
                return false;
            }
            final int i = c - 'a';
            curr = curr.next[i];
        }

        if (curr == null) return false;
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (final char c : prefix.toCharArray()) {
            if (curr == null || curr.isLeaf) {
                return false;
            }
            final int i = c - 'a';
            curr = curr.next[i];
        }

        if (curr == null) return false;
        if (curr.isWord) return true;
        if (curr.isLeaf) return false;

        final Queue<Node> q = new ArrayDeque<>();
        q.add(curr);

        while (!q.isEmpty()) {
            curr = q.remove();
            if (curr.isWord) return true;
            if (curr.isLeaf) continue;
            for (int i = 0; i < 26; ++i) {
                if (curr.next[i] != null) q.add(curr.next[i]);
            }
        }

        return false;
    }
}

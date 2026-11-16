class WordDictionary {

    static class Node {
        boolean isWord;
        Node[] next = new Node[26];
        public Node(final boolean isWord) { this.isWord = isWord; }
    }

    private final Node root = new Node(false);

    public void addWord(final String word) {
        Node curr = root;
        for (final char c : word.toCharArray()) {
            final int i = c - 'a';
            if (curr.next[i] == null) {
                curr.next[i] = new Node(false);
            }
            curr = curr.next[i];
        }
        curr.isWord = true;
    }

    public boolean search(final String word) {
        return searchInner(word, 0, root);
    }

    private boolean searchInner(final String word, final int i, final Node n) {
        if (i > word.length()) return false;
        if (n == null) return false;

        if (i == word.length()) {
            if (n.isWord) return true;
            return false;
        }

        if (word.charAt(i) == '.') {
            boolean result = false;
            for (final Node next : n.next) {
                if (next != null) {
                    result = result || searchInner(word, i+1, next);
                    if (result) break;
                }
            }

            return result;
        }

        final int chrIdx = word.charAt(i) - 'a';
        if (n.next[chrIdx] == null) return false;
        return searchInner(word, i+1, n.next[chrIdx]);
    }
}

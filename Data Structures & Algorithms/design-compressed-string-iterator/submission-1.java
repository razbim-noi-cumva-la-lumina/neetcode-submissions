class StringIterator {
    private final String s;
    private int cursor = 0;

    private char c = ' ';
    private int f = 0;

    public StringIterator(final String compressedString) {
        this.s = compressedString;
    }
    
    public char next() {
        if (cursor == s.length()) return ' ';
        if (f == 0) {
            c = s.charAt(cursor++);
            final StringBuilder bob = new StringBuilder();
            for (; cursor < s.length(); ++cursor) {
                if (s.charAt(cursor) < '0' || s.charAt(cursor) > '9')
                    break;
                bob.append(s.charAt(cursor));
            }
            f = Integer.parseInt(bob.toString());
        }

        --f;
        return c;
    }
    
    public boolean hasNext() {
        return f > 0 || cursor < s.length();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

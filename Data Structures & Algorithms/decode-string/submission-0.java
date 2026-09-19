class Solution {
    public String decodeString(final String str) {
        final Stack<Character> s = new Stack<>();
        for (final char c : str.toCharArray()) {
            if (c != ']') {
                s.push(c);
                continue;
            } 

            final StringBuilder bob = new StringBuilder();
            while (s.peek() != '[') bob.append(s.pop());
            s.pop();

            final StringBuilder num = new StringBuilder();
            while (!s.isEmpty() && Character.isDigit(s.peek())) num.append(s.pop());

            final int k = num.isEmpty() ? 1 : Integer.parseInt(num.reverse().toString());
            final String val = bob.reverse().toString();
            for (int i = 0; i < k; ++i)
                for (final char valC : val.toCharArray())
                    s.push(valC);
        }

        final StringBuilder bob = new StringBuilder();
        for (final char c : s)
            bob.append(c);

        return bob.toString();
    }
}

/*

stack [a 1, x 1, b 1, z 3, c 4]
stack []
*/
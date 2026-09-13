class Solution {
    public boolean validWordSquare(final List<String> words) {
        for (int k = 0; k < words.size(); ++k) {
            final String row = words.get(k);
            for (int i = 0; i < row.length(); ++i) {
                if (i >= words.size()) {
                    return false;
                }
                final String col = words.get(i);
                if (k >= col.length()) {
                    return false;
                }
                if (row.charAt(i) != col.charAt(k)) {
                    return false;
                }
            }
        }

        return true;
    }
}
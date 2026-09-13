class Solution {
    public String encode(List<String> strs) {
        final StringBuilder bob = new StringBuilder();
        for (final String s : strs) {
            bob.append(s.length());
            bob.append(';');
            bob.append(s);
        }
        return bob.toString();
    }

    public List<String> decode(final String str) {
        final List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) >= '0' && str.charAt(j) <= '9') ++j;
            final int len = Integer.parseInt(str.substring(i, j));
            ++j; // Skip ;
            i = j + len;
            strs.add(str.substring(j, i));
        }
        return strs;
    }
}

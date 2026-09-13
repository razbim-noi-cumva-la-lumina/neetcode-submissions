class Solution {
    public String stringShift(final String s, final int[][] shift) {
        int cursor = 0;

        for (final int[] sh : shift) {
            if (sh[0] == 0) {
                cursor += sh[1];
            } else {
                cursor -= sh[1];
            }
        }

        cursor = Math.floorMod(cursor, s.length());
        final StringBuilder bob = new StringBuilder();
        int i = cursor;
        do {
            bob.append(s.charAt(i));
            i = (i + 1) % s.length();
        } while (i != cursor);
        return bob.toString();
    }
}

class Solution {
    public boolean isOneEditDistance(final String s, final String t) {
        final int ns = s.length(), nt = t.length();
        if (ns > nt) return isOneEditDistance(t, s);
        if (Math.abs(ns - nt) > 1) return false;

        for (int i = 0; i < ns; ++i)
            if (s.charAt(i) != t.charAt(i))
                if (ns == nt)
                    return s.substring(i+1).equals(t.substring(i+1));
                else
                    return s.substring(i).equals(t.substring(i+1));
        return (ns + 1 == nt);
    }
}

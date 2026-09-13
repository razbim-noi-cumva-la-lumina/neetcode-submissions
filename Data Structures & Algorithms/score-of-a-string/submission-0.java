/*

c   o   d   e
99 111 100 101

111 - 99


*/

class Solution {
    public int scoreOfString(final String s) {
        int res = 0;
        for (int i = 1; i < s.length(); ++i) {
            res += Math.abs(
                (s.charAt(i) - 'a') - 
                (s.charAt(i - 1) - 'a')
            );
        }

        return res;
    }
}
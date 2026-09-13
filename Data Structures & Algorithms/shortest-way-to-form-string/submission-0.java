class Solution {
    public int shortestWay(final String source, final String target) {
        int cnt = 0;
        int i = 0;
        while (i < target.length()) {
            int j = 0;
            boolean progress = false;
            while (i < target.length() && j < source.length()) {
                if (source.charAt(j) == target.charAt(i)) {
                    ++i;
                    ++j;
                    progress = true;
                    continue;
                }
                ++j;
            }

            if (!progress) return -1;
            cnt++;
        }
        
        return cnt;
    }
}
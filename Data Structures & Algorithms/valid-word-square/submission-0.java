class Solution {
    public boolean validWordSquare(final List<String> words) {
        final int M = words.size();
        int N = Integer.MAX_VALUE;
        for (int i = 0; i < M; ++i) N = Math.min(N, words.get(i).length());

        for (int k = 0; k < M; ++k) {
            for (int i = 0; i < N; ++i) {
                if (words.get(k).charAt(i) != words.get(i).charAt(k)) {
                    return false;
                }
            }
        }

        return true;
    }
}

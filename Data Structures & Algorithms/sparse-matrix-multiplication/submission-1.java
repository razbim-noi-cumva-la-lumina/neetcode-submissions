
// (A,B) * (B,C) = (A, C)
class Solution {
    public int[][] multiply(final int[][] mat1, final int[][] mat2) {
        final int A = mat1.length, B = mat2.length, C = mat2[0].length;
        final int[][] res = new int[A][C];

        for (int row = 0; row < A; ++row) {
            for (int col = 0; col < C; ++col) {
                int sum = 0;
                for (int k = 0; k < B; ++k) {
                    sum = sum + mat1[row][k] * mat2[k][col];
                }

                res[row][col] = sum;
            }
        }

        return res;
    }
}

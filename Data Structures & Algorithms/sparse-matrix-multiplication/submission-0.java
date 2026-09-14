class Solution {
    public int[][] multiply(final int[][] mat1, final int[][] mat2) {
        final int[][] res = new int[mat1.length][mat1[0].length];

        for (int r1 = 0; r1 < mat1.length; ++r1) {
            final int[] mat1Row = mat1[r1];

            for (int c1 = 0; c1 < mat1Row.length; ++c1) {
                int s = 0;
                for (int r2 = 0; r2 < mat2.length; ++r2) {
                    s = s + mat1Row[c1] * mat2[r2][c1];
                }

                res[r1][c1] = s;
            }
        }

        return res;
    }
}

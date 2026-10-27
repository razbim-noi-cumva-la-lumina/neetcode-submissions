class Solution {
    public boolean searchMatrix(final int[][] matrix, final int target) {
        int l = 0, r = matrix.length;
        while (l < r) {
            final int m = l + (r - l) / 2;
            final int val = matrix[m][0];
            if (val == target) return true;
            else if (val < target) l = m + 1;
            else r = m;
        }


        final int row = l - 1;
        if (row < 0) return false;
        l = 0;
        r = matrix[0].length;
        while (l < r) {
            final int m = l + (r - l) / 2;
            final int val = matrix[row][m];
            if (val == target) return true;
            else if (val < target) l = m + 1;
            else r = m;
        }

        return false;
    }
}

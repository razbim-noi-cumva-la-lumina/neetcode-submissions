class Solution {
    public int smallestCommonElement(final int[][] mat) {
        final int m = mat.length, n = mat[0].length;
        for (final int v : mat[0]) {
            boolean ok = true;
            for (int i = 1; ok && i < m; ++i) {
                final int[] arr = mat[i];
                int l = 0, r = arr.length - 1;
                boolean found = false;
                while (l <= r) {
                    final int mid = l + (r - l) / 2;
                    if (arr[mid] == v) {
                        found = true;
                        break;
                    } else if (arr[mid] > v) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                if (!found) ok = false;
            }
            
            if (ok) return v;
        }

        return -1;
    }
}

class Solution {
    public int countElements(final int[] arr) {
        final boolean[] f = new boolean[1001];
        for (final int num : arr) f[num] = true;

        int count = 0;
        for (final int num : arr)
            if (num + 1 <= 1000 && f[num + 1])
                ++count;
                
        return count;
    }
}

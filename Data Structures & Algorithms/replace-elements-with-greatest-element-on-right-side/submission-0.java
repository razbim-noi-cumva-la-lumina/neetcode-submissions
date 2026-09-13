class Solution {
    public int[] replaceElements(final int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; --i) {
            final int val = arr[i];
            arr[i] = max;
            if (val > max) max = val;
        }

        return arr;
    }
}
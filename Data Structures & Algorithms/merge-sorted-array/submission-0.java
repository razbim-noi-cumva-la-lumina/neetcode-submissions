class Solution {
    public void merge(
        final int[] nums1, 
        final int m, 
        final int[] nums2, 
        final int n) {

        int it = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j])
                nums1[it--] = nums1[i--];
            else
                nums1[it--] = nums2[j--];
        }
        while (i >= 0) nums1[it--] = nums1[i--];
        while (j >= 0) nums1[it--] = nums2[j--];
    }
}
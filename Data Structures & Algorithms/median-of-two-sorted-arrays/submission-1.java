class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            final int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        final int n = nums1.length + nums2.length;
        final int half = n / 2;
        int l = 0, r = nums1.length;
        while (l <= r) {
            final int partSize1 = l + (r - l) / 2;
            final int partSize2 = half - partSize1;

            final int l1 = partSize1 == 0 ? Integer.MIN_VALUE : nums1[partSize1-1];
            final int r1 = partSize1 == nums1.length ? Integer.MAX_VALUE : nums1[partSize1];

            final int l2 = partSize2 == 0 ? Integer.MIN_VALUE : nums2[partSize2-1];
            final int r2 = partSize2 == nums2.length ? Integer.MAX_VALUE : nums2[partSize2];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return (double) Math.min(r1, r2);
                }

                final double sum = (double) Math.min(r1, r2) + (double) Math.max(l1, l2);
                return sum / 2.0f;
            }

            if (l1 <= r2) {
                l = partSize1 + 1;
            } else {
                r = partSize1 - 1;
            }
        }

        return 0f;
    }
}

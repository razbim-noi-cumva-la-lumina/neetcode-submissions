/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = 0;

        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {
            final int m = l + (r - l) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1)) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        peak = l;

        l = 0;
        r = peak;
        while (l <= r) {
            final int m = l + (r - l) / 2;
            final int mv = mountainArr.get(m);
            if (mv == target)
                return m;
            if (mv < target)
                l = m + 1;
            else
                r = m - 1;
        }

        l = peak;
        r = mountainArr.length() - 1;
        while (l <= r) {
            final int m = l + (r - l) / 2;
            final int mv = mountainArr.get(m);
            if (mv == target)
                return m;
            if (mv < target)
                r = m - 1;
            else
                l = m + 1;
        }

        return -1;
    }
}
class Solution {
    public boolean confusingNumber(int n) {
        final int m = n;
        int k = 0;
        while (n != 0) {
            final int rem = n % 10;
            int newRem = rem;
            switch (rem) {
                case 2, 3, 4, 5, 7:
                    return false;
                case 6:
                    newRem = 9;
                    break;
                case 9:
                    newRem = 6;
                    break;
            }
            n /= 10;
            k = k * 10 + newRem;
        }
        return m != k;
    }
}

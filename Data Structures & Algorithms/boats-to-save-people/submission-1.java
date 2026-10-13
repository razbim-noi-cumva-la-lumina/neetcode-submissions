class Solution {
    public int numRescueBoats(final int[] people, final int limit) {
        Arrays.sort(people);
        int cnt = 0, l = 0, r = people.length - 1;
        while (l <= r) {
            int sum = 0, boatCap = 2;
            while (boatCap > 0 && r >= l && sum + people[r] <= limit) {
                sum += people[r--];
                --boatCap;
            }
            
            while (boatCap > 0 && l <= r && sum + people[l] <= limit) {
                sum += people[l++];
                --boatCap;
            }

            ++cnt;
        }
        return cnt;
    }
}
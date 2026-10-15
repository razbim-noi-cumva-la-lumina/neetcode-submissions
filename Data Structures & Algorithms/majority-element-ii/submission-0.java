class Solution {

    public List<Integer> majorityElement(final int[] nums) {
        final int cap = nums.length / 3;
        final Map<Integer, Integer> m = new HashMap<>();
        for (final int num : nums)
            m.put(num, m.getOrDefault(num, 0) + 1);

        int num1 = 0, num2 = 0, num3 = 0;
        int frq1 = 0, frq2 = 0, frq3 = 0;
        for (final Map.Entry<Integer, Integer> it : m.entrySet()) {
            final int num = it.getKey();
            final int frq = it.getValue();

            if (frq > frq1) {
                frq3 = frq2;
                frq2 = frq1;
                frq1 = frq;

                num3 = num2;
                num2 = num1;
                num1 = num;
            } else if (frq > frq2) {
                frq3 = frq2;
                frq2 = frq;

                num3 = num2;
                num2 = num;
            } else if (frq > frq3) {
                frq3 = frq;
                num3 = num;
            }
        }

        final List<Integer> res = new ArrayList<>();
        if (frq3 > cap) {
            res.add(num1);
            res.add(num2);
            res.add(num3);
        } else if (frq2 > cap) {
            res.add(num1);
            res.add(num2);
        } else if (frq1 > cap) {
            res.add(num1);
        }
        return res;
    }

}
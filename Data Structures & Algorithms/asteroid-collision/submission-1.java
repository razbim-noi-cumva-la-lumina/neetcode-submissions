class Solution {
    public int[] asteroidCollision(final int[] asteroids) {
        final Stack<Integer> s = new Stack<>();
        for (int a : asteroids) {
            if (a > 0) s.push(a);
            else {
                boolean exploded = false;
                while (!s.isEmpty() && !exploded) {
                    final int el = s.peek();
                    if (el < 0) break;

                    if (el >= -a) exploded = true;
                    if (el <= -a) s.pop();
                }

                if (!exploded) s.push(a);
            }
        }

        int[] res = new int[s.size()];
        int i = 0;
        for (final int num : s) res[i++] = num;
        return res;
    }
}
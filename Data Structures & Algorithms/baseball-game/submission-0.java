class Solution {
    public int calPoints(final String[] operations) {
        final Stack<Integer> ops = new Stack<>();
        for (final String op : operations) {
            switch (op) {
                case "+":
                    final int op1 = ops.pop(), op2 = ops.peek();
                    ops.push(op1);
                    ops.push(op1+op2);
                    break;
                case "D":
                    ops.push(ops.peek()*2);
                    break;
                case "C":
                    ops.pop();
                    break;
                default:
                    ops.push(Integer.parseInt(op));
            }
        }

        int res = 0;
        for (final int num : ops) res += num;
        return res;
    }
}
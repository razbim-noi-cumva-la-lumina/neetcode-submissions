class MovingAverage {
    private final Queue<Integer> q;
    private final int size;
    
    private int cnt = 0;
    private double sum = 0d;

    public MovingAverage(final int size) {
        this.size = size;
        this.q = new LinkedList<>();
    }
    
    public double next(final int val) {
        ++cnt;
        sum += val;
        q.add(val);
        if (q.size() > size) {
            --cnt;
            sum -= q.remove();
        }

        return sum / cnt;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

class StockSpanner {
    private final Stack<Integer> s = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(final int price) {
        s.push(price);
        final Stack<Integer> ms = new Stack<>();
        for (final int num : s) ms.push(num);
        int span = 0;
        while (!ms.isEmpty() && ms.peek() <= price) {
            ms.pop();
            ++span;
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
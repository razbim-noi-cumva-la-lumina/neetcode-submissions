class MyQueue {
    final Stack<Integer> s1 = new Stack<>(),
                         s2 = new Stack<>();
    
    public void push(final int x) {
        s1.push(x);
    }
    
    public int pop() {
        final int n = s1.size();
        for (int i = 0; i < n - 1; ++i)
            s2.push(s1.pop());

        final int el = s1.pop();
        while (!s2.empty()) s1.push(s2.pop());
        return el;
    }
    
    public int peek() {
        final int n = s1.size();
        for (int i = 0; i < n - 1; ++i)
            s2.push(s1.pop());

        final int el = s1.peek();
        while (!s2.empty()) s1.push(s2.pop());
        return el;
    }
    
    public boolean empty() {
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
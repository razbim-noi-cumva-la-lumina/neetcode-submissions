class MyQueue {
    final Stack<Integer> s1 = new Stack<>(),
                         s2 = new Stack<>();
    
    public void push(final int x) {
        s1.push(x);
    }
    
    public int pop() {
        moveItems();
        return s2.pop();
    }
    
    public int peek() {
        moveItems();
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }

    private void moveItems() {
        if (s2.empty()) {
            while (!s1.empty()) s2.push(s1.pop());
        }
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
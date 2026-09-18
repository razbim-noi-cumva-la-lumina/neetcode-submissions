class MyStack {
    private Queue<Integer> q = new LinkedList<>();
    
    public void push(final int x) {
        q.add(x);
    }
    
    public int pop() {
        if (q.isEmpty()) return -1;
        final int len = q.size();
        for (int i = 0; i < len-1; ++i)
            q.add(q.remove());
        return q.remove();
    }
    
    public int top() {
        if (q.isEmpty()) return -1;
        final int len = q.size();
        for (int i = 0; i < len-1; ++i)
            q.add(q.remove());
        int el = q.remove();
        q.add(el);
        return el;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 /**
 Stack: 1 2 3 4 5
        5 4 3 2 1

 Queue: 1 2 3 4 5
        1 2 3 4 5
    
 1 2 3 4 5
 
 */
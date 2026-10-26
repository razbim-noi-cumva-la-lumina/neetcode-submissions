class MyCircularQueue {
    final int[] nums;
    int l = 0, r = -1, size = 0;

    public MyCircularQueue(int k) {
        nums = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (size + 1 > nums.length) return false;
        ++size;
        r = (r + 1) % nums.length;
        nums[r] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) return false;
        --size;
        l = (l + 1) % nums.length;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1; 
        return nums[l];
    }
    
    public int Rear() {
        if (isEmpty()) return -1; 
        return nums[r];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == nums.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
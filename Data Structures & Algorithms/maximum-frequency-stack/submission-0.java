class FreqStack {
    private int maxFreq;
    private final Map<Integer, Integer> freqMap;
    private final Map<Integer, Stack<Integer>> freqGrp;
    

    public FreqStack() {
        maxFreq = 0;
        freqMap = new HashMap<>();
        freqGrp = new HashMap<>();
    }
    
    public void push(final int val) {
        final int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        Stack<Integer> grp = freqGrp.get(freq);
        if (grp == null) {
            grp = new Stack<>();
        }

        grp.push(val);
        freqGrp.put(freq, grp);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        final Stack<Integer> stk = freqGrp.get(maxFreq);
        final int num = stk.pop();
        if (stk.empty()) {
            freqGrp.remove(maxFreq);
            while (maxFreq > 0 && !freqGrp.containsKey(maxFreq))
                --maxFreq;
        }

        final int numFreq = freqMap.get(num);
        if (numFreq == 1) {
            freqMap.remove(num);
        } else {
            freqMap.put(num, numFreq - 1);
        }

        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
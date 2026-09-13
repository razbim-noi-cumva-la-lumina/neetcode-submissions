class Logger {
    private static int DELTA_S = 10;
    private final Map<String, Integer> m = new HashMap<>();

    public Logger() {}
    
    public boolean shouldPrintMessage(
        final int timestamp,
        final String message
    ) {
        final int t = m.getOrDefault(message, -1);
        if (t != -1 && Math.abs(timestamp - t) < DELTA_S)
            return false;

        m.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

class TimeMap {
    static class T {
        String value;
        int timestamp;
        T(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    final Map<String, List<T>> m = new HashMap<>();

    
    public void set(final String key, final String value, final int timestamp) {
        List<T> l = m.get(key);
        if (l == null) {
            l = new ArrayList<>();
            m.put(key, l);
        }

        l.add(new T(value, timestamp));
    }
    
    public String get(final String key, int timestamp) {
        final List<T> data = m.get(key);
        if (data == null || data.isEmpty()) return "";
        if (timestamp < data.get(0).timestamp) return "";
        if (timestamp >= data.get(data.size() - 1).timestamp) return data.get(data.size() - 1).value;

        int l = 0, r = data.size()-1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (timestamp >= data.get(m).timestamp) {
                res = data.get(m).value;
                l = m+1;
            } else r = m-1;
        }

        return res;
    }
}

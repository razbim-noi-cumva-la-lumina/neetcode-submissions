class ZigzagIterator {

    final List<List<Integer>> streams = new ArrayList<>();
    final List<Integer> cursors = new ArrayList<>();
    int it = 0;

    public ZigzagIterator(final List<Integer> v1, final List<Integer> v2) {
        if (v1.size() > 0) {
            streams.add(v1);
            cursors.add(0);
        }
        if (v2.size() > 0) {
            streams.add(v2);
            cursors.add(0);
        }
    }

    public int next() {
        System.out.println(streams);
        System.out.println(cursors);
        
        final List<Integer> stream = streams.get(it);
        int cursor = cursors.get(it);
        final int res = stream.get(cursor++);
        if (cursor >= stream.size()) {
            streams.remove(it);
            cursors.remove(it);
        } else {
            cursors.set(it, cursor);
        }

        it = streams.size() == 0 ? 0 : (it + 1) % streams.size();
        return res;
    }

    public boolean hasNext() {
        return streams.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

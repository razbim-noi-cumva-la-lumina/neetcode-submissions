class Solution {
    public boolean areSentencesSimilar(
        final String[] sentence1,
        final String[] sentence2,
        final List<List<String>> similarPairs) {

        if (sentence1.length != sentence2.length) return false;

        final Map<String, Set<String>> sim = new HashMap<>();
        for (final List<String> p : similarPairs) {
            if (!sim.containsKey(p.get(0))) 
                sim.put(p.get(0), new HashSet<>());
            if (!sim.containsKey(p.get(1))) 
                sim.put(p.get(1), new HashSet<>());

            sim.get(p.get(0)).add(p.get(1));
            sim.get(p.get(1)).add(p.get(0));
        }

        for (int i = 0; i < sentence1.length; ++i) {
            final String w1 = sentence1[i],
                         w2 = sentence2[i];
            if (w1.equals(w2)) continue;

            final Set<String> s1 = sim.getOrDefault(w1, new HashSet<>());

            boolean found = false;
            for (final String w : s1) {
                found = w.equals(w2);
                if (found) break;
            }

            if (!found) return false;
        }

        return true;
    }
}

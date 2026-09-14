class Solution {
    public boolean areSentencesSimilar(
        final String[] sentence1,
        final String[] sentence2,
        final List<List<String>> similarPairs) {

        if (sentence1.length != sentence2.length) return false;

        final Map<String, String> sim = new HashMap<>();
        for (final List<String> p : similarPairs) {
            sim.put(p.get(0), p.get(1));
            sim.put(p.get(1), p.get(0));
        }

        for (int i = 0; i < sentence1.length; ++i) {
            final String w1 = sentence1[i],
                         w2 = sentence2[i];
            
            if (w1.equals(w2)) continue;
            if (
                !sim.getOrDefault(w1, "").equals(w2) && 
                !sim.getOrDefault(w2, "").equals(w1)
            ) {
                return false;
            }
        }

        return true;
    }
}

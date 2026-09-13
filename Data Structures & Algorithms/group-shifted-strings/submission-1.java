class Solution {
    public List<List<String>> groupStrings(final String[] strings) {
        final Map<Integer, List<String>> lenGroups = new HashMap<>();
        for (final String s : strings) {
            if (!lenGroups.containsKey(s.length())) {
                lenGroups.put(s.length(), new ArrayList<>());
            }

            lenGroups.get(s.length()).add(s);
        }

        final List<List<String>> res = new ArrayList<>();
        for (final Map.Entry<Integer, List<String>> kvp : lenGroups.entrySet()) {
            if (kvp.getKey() == 1) {
                res.add(kvp.getValue());
                continue;
            }

            final Map<String, List<String>> keyGroups = new HashMap<>();
            for (final String s : kvp.getValue()) {
                final String key = makeKey(s);
                if (!keyGroups.containsKey(key)) {
                    keyGroups.put(key, new ArrayList<>());
                }

                keyGroups.get(key).add(s);
            }

            for (final List<String> v : keyGroups.values()) {
                res.add(v);
            }
        }

        return res;
    }

    private String makeKey(final String s) {
        final StringBuilder bob = new StringBuilder();
        for (int i = 1; i < s.length(); ++i) {
            bob.append( ((s.charAt(i) - s.charAt(i - 1)) + 26) % 26 ).append('|');
        }
        return bob.toString();
    }

/**

a b c d e f g h i j k l m n o p q r s t u v w x y z


c a r -> d b s -> 

a z -> 25
b a -> 1
*/
}

class Solution {
    public String simplifyPath(final String path) {
        final Stack<String> s = new Stack<>();

        for (final String part : path.split("/")) {
            switch (part) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!s.isEmpty()) s.pop();
                    break;
                default:
                    s.push(part);
            }
        }

        final StringBuilder bob = new StringBuilder();
        for (final String part : s)
            bob.append("/").append(part);

        return bob.isEmpty() ? "/" : bob.toString();
    }
}
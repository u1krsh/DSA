class Solution {
    private String s;
    private int i;

    public List<String> braceExpansionII(String expression) {
        this.s = expression;
        this.i = 0;
        Set<String> result = parseExpr();
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parseExpr() {
        // union of terms separated by commas
        Set<String> result = parseTerm();
        while (i < s.length() && s.charAt(i) == ',') {
            i++; // skip ','
            result.addAll(parseTerm());
        }
        return result;
    }

    private Set<String> parseTerm() {
        // concatenation of factors
        Set<String> result = new HashSet<>();
        result.add("");
        while (i < s.length() && s.charAt(i) != ',' && s.charAt(i) != '}') {
            Set<String> factor = parseFactor();
            Set<String> next = new HashSet<>();
            for (String a : result) {
                for (String b : factor) {
                    next.add(a + b);
                }
            }
            result = next;
        }
        return result;
    }

    private Set<String> parseFactor() {
        Set<String> result = new HashSet<>();
        if (s.charAt(i) == '{') {
            i++; // skip '{'
            result = parseExpr();
            i++; // skip '}'
        } else {
            int j = i;
            while (j < s.length() && Character.isLowerCase(s.charAt(j))) {
                j++;
            }
            result.add(s.substring(i, j));
            i = j;
        }
        return result;
    }
}
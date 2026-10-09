class Solution {
    public int minInsertions(String s) {
        int ans = 0, open = 0;
        int i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {
                // need a "))" pair
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    ans++; // insert one ')'
                    i++;
                }
                if (open > 0) open--;
                else ans++; // insert a '('
            }
        }
        // each leftover '(' needs "))"
        return ans + open * 2;
    }
}
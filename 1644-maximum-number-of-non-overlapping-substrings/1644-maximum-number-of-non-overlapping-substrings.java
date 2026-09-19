import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }
        
        int[] end = new int[n];
        boolean[] valid = new boolean[n];
        
        // Only expand from the first-occurrence position of each char (<=26 starts)
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) continue;
            int i = first[c];
            int e = last[c];
            boolean ok = true;
            int j = i + 1;
            while (j <= e) {
                int cj = s.charAt(j) - 'a';
                if (first[cj] < i) ok = false;
                if (last[cj] > e) e = last[cj];
                j++;
            }
            end[i] = e;
            valid[i] = ok;
        }
        
        List<int[]> result = new ArrayList<>();
        solve(0, n - 1, end, valid, result);
        
        List<String> ans = new ArrayList<>();
        for (int[] p : result) ans.add(s.substring(p[0], p[1] + 1));
        return ans;
    }
    
    private void solve(int l, int r, int[] end, boolean[] valid, List<int[]> result) {
        int i = l;
        while (i <= r) {
            if (valid[i] && end[i] <= r) {
                List<int[]> inner = new ArrayList<>();
                solve(i + 1, end[i] - 1, end, valid, inner);
                if (!inner.isEmpty()) {
                    result.addAll(inner);
                } else {
                    result.add(new int[]{i, end[i]});
                }
                i = end[i] + 1;
            } else {
                i++;
            }
        }
    }
}
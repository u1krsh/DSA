class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        int[] remaining = cnt.clone();
        int bestI = -1;

        for (int i = 0; i < n; i++) {
            char t = target.charAt(i);
            for (int c = t - 'a' + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    bestI = i;
                    break;
                }
            }
            if (remaining[t - 'a'] == 0) break; 
            remaining[t - 'a']--;
        }

        if (bestI == -1) return ""; 

        int[] rem2 = cnt.clone();
        for (int j = 0; j < bestI; j++) {
            rem2[target.charAt(j) - 'a']--;
        }

        char tChar = target.charAt(bestI);
        int chosen = -1;
        for (int c = tChar - 'a' + 1; c < 26; c++) {
            if (rem2[c] > 0) { chosen = c; break; }
        }
        rem2[chosen]--;

        StringBuilder sb = new StringBuilder();
        sb.append(target, 0, bestI);      
        sb.append((char) ('a' + chosen)); 
        for (int c = 0; c < 26; c++) {    
            for (int k = 0; k < rem2[c]; k++) {
                sb.append((char) ('a' + c));
            }
        }

        return sb.toString();
    }
}
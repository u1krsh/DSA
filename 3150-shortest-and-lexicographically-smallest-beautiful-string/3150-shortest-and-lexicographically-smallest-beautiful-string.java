class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String best = "";
        int left = 0, ones = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') ones++;

            while (ones > k) {
                if (s.charAt(left) == '1') ones--;
                left++;
            }

            if (ones == k) {
                while (s.charAt(left) == '0') left++;
                String cand = s.substring(left, right + 1);
                if (best.isEmpty() || cand.length() < best.length() ||
                    (cand.length() == best.length() && cand.compareTo(best) < 0)) {
                    best = cand;
                }
            }
        }

        return best;
    }
}
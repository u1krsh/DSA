class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        char mid = '\0';

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (freq[i] % 2 == 1) {
                mid = c; 
            }
            int pairs = freq[i] / 2;
            for (int j = 0; j < pairs; j++) {
                half.append(c);
            }
        }

        StringBuilder result = new StringBuilder(half);
        if (n % 2 == 1) {
            result.append(mid);
        }
        result.append(half.reverse());

        return result.toString();
    }
}
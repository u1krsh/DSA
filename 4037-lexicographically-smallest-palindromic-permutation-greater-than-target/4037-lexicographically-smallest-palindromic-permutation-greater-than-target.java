class Solution {
    private int half;
    private int mid;

    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;
        for (int cnt : freq) {
            if ((cnt & 1) != 0) oddCount++;
        }
        if (oddCount > 1) {
            return "";
        }

        mid = -1;
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) != 0) {
                mid = i;
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        char[] ans = s.toCharArray();
        char[] tgt = target.toCharArray();
        int n = ans.length;
        half = n / 2;

        int pos = 0;
        while (pos < half) {
            int ch = tgt[pos] - 'a';
            if (freq[ch] == 0) {
                break;
            }
            ans[pos] = tgt[pos];
            freq[ch]--;
            pos++;
        }

        if (pos == half) {
            makePalindrome(ans, n);
            String candidate = new String(ans);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        while (true) {
            if (pos < half) {
                int min = tgt[pos] - 'a' + 1;
                int found = -1;
                for (int ch = min; ch < 26; ch++) {
                    if (freq[ch] != 0) {
                        found = ch;
                        break;
                    }
                }
                if (found != -1) {
                    ans[pos] = (char) ('a' + found);
                    freq[found]--;
                    int dst = pos + 1;
                    for (int ch = 0; ch < 26; ch++) {
                        int cnt = freq[ch];
                        for (int off = 0; off < cnt; off++) {
                            ans[dst + off] = (char) ('a' + ch);
                        }
                        dst += cnt;
                    }
                    makePalindrome(ans, n);
                    return new String(ans);
                }
            }
            if (pos == 0) {
                return "";
            }
            pos--;
            freq[tgt[pos] - 'a']++;
        }
    }

    private void makePalindrome(char[] buf, int n) {
        if (mid != -1) {
            buf[half] = (char) ('a' + mid);
        }
        for (int idx = 0; idx < half; idx++) {
            buf[n - 1 - idx] = buf[idx];
        }
    }
}
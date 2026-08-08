class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[] suf = new int[n + 1];
        suf[n] = m;
        for (int i = n - 1; i >= 0; i--) {
            if (suf[i + 1] > 0 && w1[i] == w2[suf[i + 1] - 1]) {
                suf[i] = suf[i + 1] - 1;
            } else {
                suf[i] = suf[i + 1];
            }
        }

        int[] result = new int[m];
        int idx = 0;
        int i = 0, j = 0;
        boolean changed = false;

        while (i < n && j < m) {
            if (w1[i] == w2[j]) {
                result[idx++] = i;
                i++;
                j++;
            } else if (!changed && suf[i + 1] <= j + 1) {
                result[idx++] = i;
                changed = true;
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (j < m) {
            return new int[0];
        }
        return result;
    }
}
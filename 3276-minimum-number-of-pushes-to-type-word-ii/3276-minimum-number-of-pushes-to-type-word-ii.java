class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Integer[] boxed = new Integer[26];
        for (int i = 0; i < 26; i++) boxed[i] = freq[i];
        Arrays.sort(boxed, Collections.reverseOrder());

        int totalPushes = 0;
        for (int i = 0; i < 26; i++) {
            if (boxed[i] == 0) break; 
            int pushesPerChar = (i / 8) + 1;
            totalPushes += boxed[i] * pushesPerChar;
        }
        return totalPushes;
    }
}
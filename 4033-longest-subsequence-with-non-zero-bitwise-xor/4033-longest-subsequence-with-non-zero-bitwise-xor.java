class Solution {
    public int longestSubsequence(int[] nums) {
        int x = 0;
        boolean allZero = true;
        for (int v : nums) {
            x ^= v;
            if (v != 0) allZero = false;
        }
        if (x != 0) return nums.length;
        if (allZero) return 0;
        return nums.length - 1;
    }
}
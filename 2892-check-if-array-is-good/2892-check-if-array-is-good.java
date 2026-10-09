class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] cnt = new int[n + 1];
        for (int x : nums) {
            if (x < 1 || x > n) return false;
            cnt[x]++;
        }
        for (int i = 1; i < n; i++) {
            if (cnt[i] != 1) return false;
        }
        return cnt[n] == 2;
    }
}
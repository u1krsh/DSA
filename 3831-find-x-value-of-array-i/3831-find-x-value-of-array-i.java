class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] cnt = new long[k];
        for (int a : nums) {
            int m = a % k;                       // reduce first, avoids overflow
            long[] next = new long[k];
            for (int r = 0; r < k; r++)
                next[(r * m) % k] += cnt[r];     // r*m < k*k <= 25, safe
            next[m]++;
            for (int r = 0; r < k; r++)
                result[r] += next[r];
            cnt = next;
        }
        return result;
    }
}
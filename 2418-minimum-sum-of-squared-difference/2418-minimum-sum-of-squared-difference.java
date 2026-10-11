class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long[] cnt = new long[max + 1];
        for (int d : diff) cnt[d]++;

        long k = (long) k1 + k2;

        for (int d = max; d >= 1 && k > 0; d--) {
            if (cnt[d] == 0) continue;
            if (k >= cnt[d]) {
                // lower every element at level d by 1
                k -= cnt[d];
                cnt[d - 1] += cnt[d];
                cnt[d] = 0;
            } else {
                // only k of them can come down
                cnt[d - 1] += k;
                cnt[d] -= k;
                k = 0;
            }
        }

        long res = 0;
        for (int d = 1; d <= max; d++) {
            res += cnt[d] * (long) d * d;
        }
        return res;
    }
}
class Solution {
    int[] suffixSum;
    Integer[][] memo;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        memo = new Integer[n][n + 1];
        return solve(0, 1, piles);
    }

    private int solve(int i, int M, int[] piles) {
        int n = piles.length;
        if (i == n) return 0;
        if (2 * M >= n - i) return suffixSum[i]; 

        if (memo[i][M] != null) return memo[i][M];

        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            if (i + X > n) break;
            int taken = suffixSum[i] - suffixSum[i + X];
            int opponent = solve(i + X, Math.max(M, X), piles);
            best = Math.max(best, taken + (suffixSum[i + X] - opponent));
        }
        memo[i][M] = best;
        return best;
    }
}
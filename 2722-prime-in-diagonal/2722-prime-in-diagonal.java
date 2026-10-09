class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int best = 0;
        for (int i = 0; i < n; i++) {
            int a = nums[i][i];
            int b = nums[i][n - i - 1];
            if (a > best && isPrime(a)) best = a;
            if (b > best && isPrime(b)) best = b;
        }
        return best;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        if (x < 4) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; (long) i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
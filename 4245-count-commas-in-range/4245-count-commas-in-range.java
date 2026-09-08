class Solution {
    public int countCommas(int n) {
        long total = 0;
        long lower = 1;
        int digits = 1;
        while (lower <= n) {
            long upper = lower * 10 - 1;
            long high = Math.min(upper, n);
            long count = high - lower + 1;
            long commasPerNumber = (digits - 1) / 3;
            total += count * commasPerNumber;
            lower *= 10;
            digits++;
        }
        return (int) total;
    }
}
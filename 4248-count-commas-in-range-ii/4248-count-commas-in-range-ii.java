class Solution {
    public long countCommas(long n) {
        long big = 999;

        long sum = 0;

        while(n > big){
            sum += n - big;
            big = big * 1000 + 999;
        }
        return sum;
    }
}
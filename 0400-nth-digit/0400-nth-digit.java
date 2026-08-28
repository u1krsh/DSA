class Solution {
    public int findNthDigit(int n) {
        long d = 1;              
        long count = 9;           
        long start = 1;           

        while (n > d * count) {
            n -= d * count;
            d++;
            count *= 10;
            start *= 10;
        }

        long number = start + (n - 1) / d;

        int digitIndex = (int) ((n - 1) % d);
        String numStr = Long.toString(number);

        return numStr.charAt(digitIndex) - '0';
    }
}
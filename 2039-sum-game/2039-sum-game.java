class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftQ = 0, leftSum = 0;
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') leftQ++;
            else leftSum += num.charAt(i) - '0';
        }

        int rightQ = 0, rightSum = 0;
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') rightQ++;
            else rightSum += num.charAt(i) - '0';
        }

        int totalQ = leftQ + rightQ;
        int sumDiff = leftSum - rightSum;
        int qDiff = rightQ - leftQ;

        return totalQ % 2 == 1 || sumDiff != 9 * qDiff / 2;
    }
}
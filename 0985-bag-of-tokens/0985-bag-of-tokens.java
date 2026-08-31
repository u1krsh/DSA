class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int lo = 0, hi = tokens.length - 1;
        int score = 0, maxScore = 0;
        
        while (lo <= hi) {
            if (power >= tokens[lo]) {
                power -= tokens[lo];
                score++;
                maxScore = Math.max(maxScore, score);
                lo++;
            } else if (score > 0) {
                power += tokens[hi];
                score--;
                hi--;
            } else {
                break;
            }
        }
        
        return maxScore;
    }
}
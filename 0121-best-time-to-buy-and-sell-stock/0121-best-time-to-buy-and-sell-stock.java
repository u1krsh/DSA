class Solution {
    public int maxProfit(int[] prices) {
        int prof =0, min = prices[0];
        for(int i =0;i<prices.length;i++){
            int cost = prices[i] -min;
            prof = Math.max(prof,cost);
            min = Math.min(min,prices[i]);
        }

        return prof;
    }
}
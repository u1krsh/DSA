class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int prof =0;
        for(int i =1;i<prices.length;i++){
            int cast = prices[i] -min;
            prof = Math.max(prof,cast);
            min = Math.min(min,prices[i]);
        }
        return prof;
    }
}
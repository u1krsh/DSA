class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int posIn = 0;
        int negIn = 1;

        for(int i = 0;i<n;i++){
            if(nums[i]<0){
                ans[negIn] = nums[i];
                negIn += 2;
            }
            else{
                ans[posIn] = nums[i];
                posIn += 2;
            }
        }
        return ans;
    }
}
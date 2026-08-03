class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int preSum = 0, cnt =0;
        for(int i =0;i<nums.length;i++){
            preSum += nums[i];
            int rem = preSum -k;
            cnt += mpp.getOrDefault(rem,0);
            mpp.merge(preSum,1,Integer::sum);
        }
        return cnt;
    }
}
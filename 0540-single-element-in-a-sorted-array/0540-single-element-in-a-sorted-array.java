class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0, high  = n-1;
        while(low<high){
            int mid = low +(high-low)/2;
            if(mid %2 != 0) mid--;

            if(nums[mid+1] == nums[mid]){
                low = mid +2;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }
}
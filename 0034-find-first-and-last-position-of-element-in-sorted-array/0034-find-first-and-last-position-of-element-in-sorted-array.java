class Solution {
    static int lowerBound(int[] nums, int n, int target){
        int low =0,  high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=target){
                ans = mid;
                high = mid-1;

            }
            else{
                low = mid +1;
            } 
        }
        return ans;
    }

    static int upperBound(int[] nums, int n, int target){
        int low = 0, high = n-1;
        int ans = n;

        while(low<=high){
            int mid = (high+low)/2;
            if(nums[mid] > target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }


    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, nums.length, target);
        if(lb == nums.length || nums[lb] != target) {
            return new int[] {-1,-1};
            }
        return new int[] {lb, upperBound(nums, nums.length,target)-1};
    }
}
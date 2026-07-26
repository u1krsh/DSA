class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp1 = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp1;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { 
                int temp2 = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp2;
                high--;
            }
        }
    }
}
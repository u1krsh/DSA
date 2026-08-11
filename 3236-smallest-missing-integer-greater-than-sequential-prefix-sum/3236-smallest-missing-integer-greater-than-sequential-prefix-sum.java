class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i] == nums[i - 1] + 1) {
            i++;
        }
        
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += nums[j];
        }
        
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
        }
        
        while (present.contains(sum)) {
            sum++;
        }
        
        return sum;
    }
}
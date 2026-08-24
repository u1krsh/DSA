class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        int ops = 0;
        for (int f : freq.values()) {
            if (f == 1) return -1; 
            ops += (f + 2) / 3; 
        }
        return ops;
    }
}
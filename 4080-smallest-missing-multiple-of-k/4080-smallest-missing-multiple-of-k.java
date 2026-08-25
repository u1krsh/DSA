class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 1; ; i++) {
            int candidate = k * i;
            if (Arrays.binarySearch(nums, candidate) < 0) {
                return candidate;
            }
        }
    }
}
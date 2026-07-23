class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int h = 31 - Integer.numberOfLeadingZeros(n); // floor(log2(n))
        return 1 << (h + 1);
    }
}
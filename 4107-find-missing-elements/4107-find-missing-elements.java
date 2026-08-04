class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int n : nums) {
            lo = Math.min(lo, n);
            hi = Math.max(hi, n);
        }

        boolean[] present = new boolean[hi - lo + 1];
        for (int n : nums) {
            present[n - lo] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= hi - lo; i++) {
            if (!present[i]) {
                result.add(i + lo);
            }
        }
        return result;
    }
}
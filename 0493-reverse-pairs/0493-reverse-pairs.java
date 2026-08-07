class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        int[] merged = new int[right - left + 1];
        int i = left, k = mid + 1, idx = 0;
        while (i <= mid && k <= right) {
            if (nums[i] <= nums[k]) merged[idx++] = nums[i++];
            else merged[idx++] = nums[k++];
        }
        while (i <= mid) merged[idx++] = nums[i++];
        while (k <= right) merged[idx++] = nums[k++];

        System.arraycopy(merged, 0, nums, left, merged.length);
        return count;
    }
}
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int row = 0; row < m; row++) {
            int low = 0, high = n - 1;
            int firstNegIdx = n;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (grid[row][mid] < 0) {
                    firstNegIdx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            count += (n - firstNegIdx);
        }

        return count;
    }
}
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int minCol = 0;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < matrix[i][minCol]) {
                    minCol = j;
                }
            }

            int value = matrix[i][minCol];
            boolean lucky = true;

            for (int r = 0; r < m; r++) {
                if (matrix[r][minCol] > value) {
                    lucky = false;
                    break;
                }
            }

            if (lucky) {
                ans.add(value);
            }
        }

        return ans;
    }
}
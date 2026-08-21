class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) arr[top][j] = num++;
            top++;

            for (int i = top; i <= bottom; i++) arr[i][right] = num++;
            right--;

            for (int j = right; j >= left; j--) arr[bottom][j] = num++;
            bottom--;

            for (int i = bottom; i >= top; i--) arr[i][left] = num++;
            left++;
        }

        return arr;
    }
}
class Solution {
static void reverse(int[][] array) {
    if (array == null || array.length == 0) return;

    for (int i = 0; i < array.length; i++) {
        int left = 0;
        int right = array[i].length - 1;

        while (left < right) {
            int temp = array[i][left];
            array[i][left] = array[i][right];
            array[i][right] = temp;

            left++;
            right--;
        }
    }
}

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i =0;i<n;i++){
            for (int j = i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        reverse(matrix);
    }
}
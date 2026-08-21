class Solution {
    public int diagonalSum(int[][] mat) {
        int ps =0, os =0;
        int n = mat.length;
        for(int i =0;i<mat.length;i++){
            ps += mat[i][i];
            os += mat[i][mat.length-1-i];
        }
        return ((n & 1)==1) ? ps+os-mat[mat.length/2][mat.length/2] : ps+os;
    }
}
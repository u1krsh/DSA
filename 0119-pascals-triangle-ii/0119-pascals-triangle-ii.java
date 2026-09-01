class Solution {
    static List<Integer> calc_row(int n){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col =1; col<n;col++){
                ans = ans * (n-col);
                ans = ans / (col);
                ansRow.add((int)ans);
        }
        return ansRow;
    }


    public List<Integer> getRow(int rowIndex) {
        return calc_row(rowIndex+1);
    }
}
class Solution {

    static List<Integer> calc_row(int n){
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col =1; col<n;col++){
                ans = ans * (n-col);
                ans = ans / (col);
                ansRow.add(ans);
        }
        return ansRow;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> anss = new ArrayList<>();
        for(int i = 1;i<=numRows;i++){
            anss.add(calc_row(i));
        }

        return anss;
    }
}
class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        List<Integer> sus = new ArrayList<>();
        while(n >0){
            sum += n %k;
            n = n/k;
            
        }
        return sum;
    }
}
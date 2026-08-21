class Solution {
    public int subtractProductAndSum(int n) {
        int pro = 1;
        int sum = 0;
        while(n != 0 ){
            int x = n%10;
            sum += x;
            pro *= x;
            n = n/10;
        }
        return pro-sum;
    }
}
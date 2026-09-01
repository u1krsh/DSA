class Solution {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n==3) return 2;

        int pro = 1;

        while(n>4){
            pro = pro *3;
            n = n -3;
        }
        return pro * n;

    }
}
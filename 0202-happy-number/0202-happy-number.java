class Solution {

    private int square(int n){
        int ans = 0;
        while(n>0){
            int remo = n %10;
            ans += remo*remo;
            n = n/10;
        }
        return ans;

    }

    public boolean isHappy(int n) {
        int hare = n;
        int turtle = n;

        do{
            turtle = square(turtle);
            hare = square(square(hare));
        }while(hare != turtle);

        if(hare == 1) return true;
        else return false;
    }
}
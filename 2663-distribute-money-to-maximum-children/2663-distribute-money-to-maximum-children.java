class Solution {
    public int distMoney(int money, int children) {
        money -= children;
        if(money<0 ) return -1;

        int eight = Math.min(money/7,children);
        money -= eight *7;
        int remaining  = children-eight;

        if(remaining == 0 && money > 0){
            eight--;
            remaining++;
            money += 7;
        }
        if(remaining == 1 && money == 3){
            eight--;
            money += 7;
        }
        return eight;
    }
}
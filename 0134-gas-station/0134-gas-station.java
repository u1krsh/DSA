class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int tot = 0, currGas = 0, start = 0;
        for(int i = 0 ;i < gas.length;i++){
            int diff = gas[i] - cost[i];
            tot += diff;
            currGas += diff;
            if(currGas < 0){
                start = i+1;
                currGas = 0;
            }
        }
        if(tot >= 0) return start;
        else return -1;
    }
}
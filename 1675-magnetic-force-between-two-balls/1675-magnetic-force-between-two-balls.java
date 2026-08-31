class Solution {

    private boolean canWePlace(int[] arr, int dist, int ball){
        int cntBall = 1, coordinate = arr[0];
        for(int i =1; i< arr.length;i++){
            if(arr[i] - coordinate >= dist){
            cntBall++;
            coordinate = arr[i];
            }
        }
        return cntBall >= ball;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 0, high = position[position.length-1] - position[0];
        while(low<= high){
            int mid = low + (high-low)/2;
            if(canWePlace(position, mid, m)){
                low = mid+1;
            }
            else high = mid-1;
        }
        return high;
    }
}
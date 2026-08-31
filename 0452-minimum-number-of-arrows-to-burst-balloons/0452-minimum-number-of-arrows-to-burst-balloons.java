class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        int arrwows = 1;
        int arrowPos = points[0][1];


        for(int i = 0; i<points.length;i++){
            if(points[i][0] > arrowPos){
                arrwows += 1;
                arrowPos = points[i][1];
            }
        }
        return arrwows;

    }
}
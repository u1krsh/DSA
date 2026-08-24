class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        long dx = Math.abs((long) fx - sx);
        long dy = Math.abs((long) fy - sy);
        long minMoves = Math.max(dx, dy);

        if (minMoves == 0) {
            return t != 1;
        }
        return t >= minMoves;
    }
}
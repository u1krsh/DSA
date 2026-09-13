import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) ones1.add(new int[]{r, c});
                if (img2[r][c] == 1) ones2.add(new int[]{r, c});
            }
        }
        
        Map<Long, Integer> shiftCount = new HashMap<>();
        int best = 0;
        
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int dr = p1[0] - p2[0];
                int dc = p1[1] - p2[1];
                long key = (long) dr * 2000L + dc;
                int count = shiftCount.merge(key, 1, Integer::sum);
                best = Math.max(best, count);
            }
        }
        
        return best;
    }
}
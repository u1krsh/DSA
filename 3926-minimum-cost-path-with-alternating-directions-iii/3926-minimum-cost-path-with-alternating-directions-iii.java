import java.util.*;

class Solution {
    public long minCost(int m, int n, int[][] penalty) {
        if (m == 1 && n == 1) {
            return 1L;
        }

        int total = m * n;
        long[] dist = new long[total * 2];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        long startCost = 1L * (0 + 1) * (0 + 1);
        dist[0] = startCost;
        pq.offer(new long[]{startCost, 0, 0, 0});

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int i = (int) cur[1], j = (int) cur[2], p = (int) cur[3];
            int state = (i * n + j) * 2 + p;
            if (d > dist[state]) continue;

          
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;

                boolean isForward = (dir[0] == 1 && dir[1] == 0) || (dir[0] == 0 && dir[1] == 1);
                boolean follows = (p == 0) ? isForward : !isForward;
                long entrance = 1L * (ni + 1) * (nj + 1);
                long cost = entrance + (follows ? 0 : penalty[i][j]);
                int newP = 1 - p;
                int newState = (ni * n + nj) * 2 + newP;
                long nd = d + cost;
                if (nd < dist[newState]) {
                    dist[newState] = nd;
                    pq.offer(new long[]{nd, ni, nj, newP});
                }
            }

            long waitCost = penalty[i][j];
            int newP = 1 - p;
            int newState = (i * n + j) * 2 + newP;
            long nd = d + waitCost;
            if (nd < dist[newState]) {
                dist[newState] = nd;
                pq.offer(new long[]{nd, i, j, newP});
            }
        }

        int target0 = ((m - 1) * n + (n - 1)) * 2 + 0;
        int target1 = ((m - 1) * n + (n - 1)) * 2 + 1;
        return Math.min(dist[target0], dist[target1]);
    }
}
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) grid[i] = classroom[i].toCharArray();
        
        int sr = -1, sc = -1;
        List<int[]> litterCells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 'S') { sr = i; sc = j; }
                else if (grid[i][j] == 'L') litterCells.add(new int[]{i, j});
        
        int L = litterCells.size();
        if (L == 0) return 0;
        
        int[][] litterBit = new int[m][n];
        for (int[] row : litterBit) Arrays.fill(row, -1);
        for (int k = 0; k < L; k++) {
            int[] pos = litterCells.get(k);
            litterBit[pos[0]][pos[1]] = k;
        }
        
        int fullMask = (1 << L) - 1;
        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << L];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc, energy, 0});
        visited[sr][sc][energy][0] = true;
        
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1], e = cur[2], mask = cur[3];
                if (mask == fullMask) return moves;
                if (e <= 0) continue;
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 'X') continue;
                    
                    int newEnergy = (grid[nr][nc] == 'R') ? energy : e - 1;
                    int newMask = mask;
                    if (grid[nr][nc] == 'L' && litterBit[nr][nc] != -1) {
                        newMask |= (1 << litterBit[nr][nc]);
                    }
                    
                    if (!visited[nr][nc][newEnergy][newMask]) {
                        visited[nr][nc][newEnergy][newMask] = true;
                        if (newMask == fullMask) return moves + 1;
                        queue.offer(new int[]{nr, nc, newEnergy, newMask});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
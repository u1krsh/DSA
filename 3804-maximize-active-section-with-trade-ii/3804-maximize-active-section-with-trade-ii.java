import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int[] start = new int[n], end = new int[n], type = new int[n];
        int m = 0, i = 0, totalOnes = 0;
        
        // Run-Length Encoding (RLE) to group consecutive identical characters
        while (i < n) {
            int j = i;
            char c = s.charAt(i);
            while (j < n && s.charAt(j) == c) j++;
            start[m] = i; end[m] = j - 1; type[m] = c - '0';
            if (c == '1') totalOnes += (j - i);
            m++; i = j;
        }
        
        int[] len = new int[m], blockStart = new int[m];
        for (int k = 0; k < m; k++) { 
            len[k] = end[k] - start[k] + 1; 
            blockStart[k] = start[k]; 
        }

        // Calculate potential gains
        int NEG = Integer.MIN_VALUE / 2;
        int[] val = new int[m];
        for (int k = 0; k < m; k++) {
            val[k] = (type[k] == 1 && k - 1 >= 0 && k + 1 < m) ? len[k-1] + len[k+1] : NEG;
        }

        // Build Sparse Table for O(1) Range Maximum Queries (RMQ)
        int LOG = 1;
        while ((1 << LOG) <= m) LOG++;
        int[][] table = new int[LOG + 1][m];
        table[0] = val.clone();
        for (int k = 1; k <= LOG; k++) {
            int half = 1 << (k - 1);
            for (int idx = 0; idx + (1 << k) <= m; idx++) {
                table[k][idx] = Math.max(table[k-1][idx], table[k-1][idx + half]);
            }
        }
        
        int[] log2 = new int[m + 1];
        for (int k = 2; k <= m; k++) {
            log2[k] = log2[k/2] + 1;
        }

        // Process Queries
        int Q = queries.length;
        List<Integer> answer = new ArrayList<>(Q);
        
        for (int qi = 0; qi < Q; qi++) {
            int l = queries[qi][0], r = queries[qi][1];
            int bs = findBlock(blockStart, l);
            int be = findBlock(blockStart, r);
            int gain = 0;
            
            if (be - bs >= 2) {
                // Check edge blocks manually as they might be partially outside the query range
                int j1 = bs + 1;
                if (type[j1] == 1) {
                    int left = end[bs] - l + 1;
                    int right = (j1 + 1 == be) ? (r - start[be] + 1) : len[j1 + 1];
                    gain = Math.max(gain, left + right);
                }
                
                int j2 = be - 1;
                if (j2 != j1 && type[j2] == 1) {
                    int right = r - start[be] + 1;
                    int left = (j2 - 1 == bs) ? (end[bs] - l + 1) : len[j2 - 1];
                    gain = Math.max(gain, left + right);
                }
                
                // Query strictly internal blocks using the Sparse Table
                int lo = bs + 2, hi = be - 2;
                if (lo <= hi) {
                    int k = log2[hi - lo + 1];
                    int mx = Math.max(table[k][lo], table[k][hi - (1 << k) + 1]);
                    gain = Math.max(gain, mx);
                }
            }
            // Add the final calculated maximum to the result list
            answer.add(totalOnes + gain);
        }
        return answer;
    }

    private int findBlock(int[] blockStart, int pos) {
        int lo = 0, hi = blockStart.length - 1, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (blockStart[mid] <= pos) { 
                ans = mid; 
                lo = mid + 1; 
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
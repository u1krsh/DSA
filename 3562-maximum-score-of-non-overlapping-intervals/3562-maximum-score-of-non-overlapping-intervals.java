import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int[] rights = new int[n];
        for (int i = 0; i < n; i++) rights[i] = arr[i][1];

        long[][] score = new long[n + 1][5];
        List<Integer>[][] idxList = new List[n + 1][5];
        for (int j = 0; j <= 4; j++) idxList[0][j] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int l = arr[i - 1][0], w = arr[i - 1][2], orig = arr[i - 1][3];
            int p = lowerBound(rights, 0, i - 1, l);

            for (int j = 0; j <= 4; j++) {
                long bestScore = score[i - 1][j];
                List<Integer> bestList = idxList[i - 1][j];

                if (j >= 1) {
                    long candScore = score[p][j - 1] + w;
                    List<Integer> candList = insertSorted(idxList[p][j - 1], orig);
                    if (isBetter(candScore, candList, bestScore, bestList)) {
                        bestScore = candScore;
                        bestList = candList;
                    }
                }
                score[i][j] = bestScore;
                idxList[i][j] = bestList;
            }
        }

        List<Integer> ans = idxList[n][4];
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) result[i] = ans.get(i);
        return result;
    }

    private boolean isBetter(long candScore, List<Integer> candList, long bestScore, List<Integer> bestList) {
        if (candScore != bestScore) return candScore > bestScore;
        int len = Math.min(candList.size(), bestList.size());
        for (int i = 0; i < len; i++) {
            if (!candList.get(i).equals(bestList.get(i))) {
                return candList.get(i) < bestList.get(i);
            }
        }
        return candList.size() < bestList.size();
    }

    private List<Integer> insertSorted(List<Integer> list, int val) {
        List<Integer> res = new ArrayList<>(list);
        int pos = 0;
        while (pos < res.size() && res.get(pos) < val) pos++;
        res.add(pos, val);
        return res;
    }

    private int lowerBound(int[] arr, int from, int to, int target) {
        int lo = from, hi = to;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
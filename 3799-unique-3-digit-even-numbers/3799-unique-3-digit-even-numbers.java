import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) cnt[d]++;

        List<Integer> present = new ArrayList<>();
        for (int d = 0; d <= 9; d++) if (cnt[d] > 0) present.add(d);
        int n = present.size();

        int total = 0;

        for (int c : new int[]{0, 2, 4, 6, 8}) {
            if (cnt[c] == 0) continue;

            int c1 = cnt[c] - 1;
            int nAfterC = n - (c1 == 0 ? 1 : 0);

            for (int a : present) {
                if (a == 0) continue;
                if (a == c && c1 == 0) continue;

                int adjusted = (a == c) ? c1 : cnt[a];
                total += nAfterC - (adjusted == 1 ? 1 : 0);
            }
        }

        return total;
    }
}
class Solution {
    char[] arr;
    int[] pre, suf, maxLen, segLen;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length(), k = queryCharacters.length();
        arr = s.toCharArray();
        pre = new int[4 * n];
        suf = new int[4 * n];
        maxLen = new int[4 * n];
        segLen = new int[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            arr[idx] = queryCharacters.charAt(i);
            update(1, 0, n - 1, idx);
            ans[i] = maxLen[1];
        }
        return ans;
    }

    private void build(int node, int l, int r) {
        segLen[node] = r - l + 1;
        if (l == r) {
            pre[node] = suf[node] = maxLen[node] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        merge(node, l, mid, r);
    }

    private void update(int node, int l, int r, int idx) {
        if (l == r) return;
        int mid = (l + r) / 2;
        if (idx <= mid) update(2 * node, l, mid, idx);
        else update(2 * node + 1, mid + 1, r, idx);
        merge(node, l, mid, r);
    }

    private void merge(int node, int l, int mid, int r) {
        int left = 2 * node, right = 2 * node + 1;
        int leftLen = mid - l + 1, rightLen = r - mid;

        if (pre[left] == leftLen && arr[mid] == arr[mid + 1]) {
            pre[node] = leftLen + pre[right];
        } else {
            pre[node] = pre[left];
        }

        if (suf[right] == rightLen && arr[mid] == arr[mid + 1]) {
            suf[node] = rightLen + suf[left];
        } else {
            suf[node] = suf[right];
        }

        maxLen[node] = Math.max(maxLen[left], maxLen[right]);
        if (arr[mid] == arr[mid + 1]) {
            maxLen[node] = Math.max(maxLen[node], suf[left] + pre[right]);
        }
    }
}
class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        long[] end = new long[26];
        long total = 0;

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            long newEnd = (total + 1) % MOD;    
            total = (total - end[c] + newEnd + MOD) % MOD;
            end[c] = newEnd;
        }

        return (int) (total % MOD);
    }
}
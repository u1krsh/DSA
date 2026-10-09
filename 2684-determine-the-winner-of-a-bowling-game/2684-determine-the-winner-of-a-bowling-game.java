class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int a = score(player1);
        int b = score(player2);
        if (a > b) return 1;
        if (b > a) return 2;
        return 0;
    }

    private int score(int[] p) {
        int total = 0;
        for (int i = 0; i < p.length; i++) {
            boolean doubled = (i >= 1 && p[i - 1] == 10) || (i >= 2 && p[i - 2] == 10);
            total += doubled ? 2 * p[i] : p[i];
        }
        return total;
    }
}
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMask = new HashMap<>();

        for (int[] rs : reservedSeats) {
            int row = rs[0], seat = rs[1];
            if (seat < 2 || seat > 9) continue; 
            rowMask.merge(row, 1 << (seat - 1), (a, b) -> a | b);
        }

        int leftMask   = 0b0000011110; 
        int middleMask = 0b0001111000; 
        int rightMask  = 0b0111100000;  

        int result = 2 * (n - rowMask.size());

        for (int mask : rowMask.values()) {
            boolean leftFree   = (mask & leftMask) == 0;
            boolean rightFree  = (mask & rightMask) == 0;
            boolean middleFree = (mask & middleMask) == 0;

            if (leftFree && rightFree) {
                result += 2;
            } else if (leftFree || middleFree || rightFree) {
                result += 1;
            }
        }

        return result;
    }
}
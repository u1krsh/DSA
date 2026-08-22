class Solution {

    static int reverse(int n, int rev){
        if(n == 0) return rev;
        return reverse(n / 10, rev * 10 + n % 10);
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        return x == reverse(x, 0);
    }
}
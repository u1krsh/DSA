class Solution {
    // private Node head;
    // private class Node {
    //     private int val;
    //     private Node next;

    //     public Node(int val) {
    //         this.val = val;
    //     }

    //     public Node(Node next, int val) {
    //         this.next = next;
    //         this.val = val;
    //     }
    // }

    private int findSquare(int n){
        int ans = 0;
        while(n>0){
            int remo = n %10;
            ans += remo * remo;
            n = n/10;
        }
        return ans;
    }


    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        if(slow==1) return true;
        else return false;
    }
}
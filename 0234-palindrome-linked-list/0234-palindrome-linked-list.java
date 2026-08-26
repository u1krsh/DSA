/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
public ListNode middleNode(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return turtle;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode prev = null;
        ListNode pres = head;
        ListNode nex = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = nex;
            if(nex != null){
                nex=nex.next;
            }
        }
        return prev ;
    }
    //pallindrome
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode temp = headSecond;
        while (head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }
            head=head.next;
            headSecond = headSecond.next;
        }
        reverseList(temp);
        return head == null || headSecond == null;
    }
}
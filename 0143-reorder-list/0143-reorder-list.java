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
    public void reorderList(ListNode head) {
        if(head==null || head.next == null) return;

        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;
        while(hf != null && hs != null) {
            ListNode temp1 = hf.next;
            hf.next = hs;
            hf = temp1;

            temp1 = hs.next;
            hs.next = hf;
            hs = temp1;
        }
        if(hf != null){
            hf.next = null;
        }
    }
}
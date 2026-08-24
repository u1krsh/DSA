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
public ListNode reverseBetween(ListNode head, int left, int right) {
    
        if(left==right) return head;

        //skip the first n-1 nodes
        ListNode curr = head;
        ListNode prev = null;
        for(int i = 0 ;curr != null && i<left-1;i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode last = prev;
        ListNode newEnd = curr;


        //reverse between left and right
        ListNode nex = curr.next;
        for(int i = 0;curr != null && i<(right-left)+1;i++){
            curr.next = prev;
            prev = curr;
            curr = nex;
            if(nex != null) {
                nex = nex.next;
            }
        }

        if(last != null){
            last.next = prev;
        }
        else{
            head = prev;
        }

        newEnd.next = curr;

        return head;
}
}
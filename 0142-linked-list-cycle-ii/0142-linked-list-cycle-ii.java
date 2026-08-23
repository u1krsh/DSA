/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public int lenghtCycle(ListNode ll){
        ListNode hare = ll;
        ListNode turtle = ll;

        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;

            if(hare==turtle){
                ListNode temp = hare;
                int length =0;
                do{
                    temp = temp.next;
                    length++;
                }while(temp!= turtle);
                return length;
            }
        }
        return 0;

    }



    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;
        int length = 0;
        while(hare != null && hare.next !=null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(hare==turtle){
                length = lenghtCycle(turtle);
                break;
            }
        }
        if(length==0) return null;
        //find start

        ListNode first = head;
        ListNode second = head;
        
        while(length>0){
            second = second.next;
            length--;
        }
        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;

    }
}
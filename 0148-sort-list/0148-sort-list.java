class Solution {

    public ListNode middleNode(ListNode head){
        ListNode prev = null;
        ListNode hare = head;
        ListNode turtle = head;

        while(hare != null && hare.next != null){
            prev = turtle;
            turtle = turtle.next;
            hare = hare.next.next;
        }
        prev.next = null;
        return turtle;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode heady = new ListNode();
        ListNode curr = heady;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }
        if(list1 != null){
            curr.next = list1;
        }
        else{
            curr.next  = list2;
        }
        return heady.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode mid = middleNode(head); 
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left,right);
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldCopy = new HashMap<>();

        Node curr = head;
        while(curr!= null){
            Node copy = new Node(curr.val);
            oldCopy.put(curr,copy);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = oldCopy.get(curr);
            copy.next = oldCopy.get(curr.next);
            copy.random = oldCopy.get(curr.random);
            curr = curr.next;
        }
        return oldCopy.get(head);
    }
}
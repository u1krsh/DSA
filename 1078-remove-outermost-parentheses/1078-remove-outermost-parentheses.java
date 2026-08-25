class Solution {
    Node head;
    int size =0;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    void push(int val) {
        head = new Node(val, head);
        size++;
    }

    int pop() {
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }
    boolean isEmpty() {
        return head == null;
    }

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();

        for(char c: s.toCharArray()){
            if(c == '('){
                if(size >0){
                    result.append(c);
                }
                push(1);
            }
            else{
                pop();
                if(size >0){
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
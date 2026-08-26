class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> helper;
    public MyQueue() {
        helper = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(!stack.isEmpty()){
            helper.push(stack.pop());
        }
        int l = helper.pop();
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return l;
    }
    
    public int peek() {
        while(!stack.isEmpty()){
            helper.push(stack.pop());
        }
        int l=  helper.peek();
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return l;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
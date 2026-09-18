class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>(); //To support O(1), this points to use of secondary stack    
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty()){
            int currentMin = minStack.peekFirst();
            if(val <= currentMin) {
                //if its less than or even equal to the min val, i push it again in minstack       
                minStack.push(val);
            }
        }else{                             //empty min stack, push whichever comes in
            minStack.push(val);
        }
    }
    
    public void pop() {
        //if the min value is at top and popd, should be removed from both stacks
        if(stack.peekFirst().equals(minStack.peekFirst())){
            minStack.pop();
        }
        stack.pop();
       
    }
    
    //no min related operations in peek, since is plain return
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}

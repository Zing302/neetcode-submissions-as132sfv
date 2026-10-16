class MinStack {
    private Stack<Integer> stk;
    private Stack<Integer> min;
    public MinStack() {
        stk=new Stack<Integer>();
        min=new Stack<Integer>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else if(val<=min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        if(!stk.isEmpty()){
            int pop=stk.pop();
            if(min.peek()==pop){
                min.pop();
            }
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min.peek();
        
    }
}

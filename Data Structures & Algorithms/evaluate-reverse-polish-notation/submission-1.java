class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0){
            return -1;
        }
        Stack<Integer> stk = new Stack<Integer>();
        for(String t:tokens){
            if(t.equals("+")){
                stk.push(stk.pop() + stk.pop());
            }else if(t.equals("-")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b - a);
            }else if(t.equals("*")){
                stk.push(stk.pop() * stk.pop());
            }else if(t.equals("/")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b / a);
            }else{
                stk.push(Integer.parseInt(t));
            }
        }
        return stk.pop();
    }
}

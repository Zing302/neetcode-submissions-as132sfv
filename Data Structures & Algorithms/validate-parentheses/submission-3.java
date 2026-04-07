class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stk.push(s.charAt(i));
            }
            if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']'){
                if(stk.isEmpty()){
                    return false;
                }
                if(s.charAt(i)==')'){
                    if(stk.peek()!='('){
                        return false;
                    }
                }else if(s.charAt(i)=='}'){
                    if(stk.peek()!='{'){
                        return false;
                    }
                }else{
                    if(stk.peek()!='['){
                        return false;
                    }
                }
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}

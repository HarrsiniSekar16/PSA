class Solution {
    public int minAddToMakeValid(String S) {
           if(S.isEmpty()){
        return 0;
    }
    Stack<Character> stack = new Stack<>();
    for(char c : S.toCharArray()){
        if(c == '('){
            stack.push(c);
        }else{
            if(!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
    }
    return stack.size();
 
    }
}
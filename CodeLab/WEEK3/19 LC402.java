class Solution {
  public String removeKdigits(String num, int k) {
    Stack<Character> stack = new Stack();
    for(char c : num.toCharArray()){         
        while(k>0&&!stack.isEmpty()&&stack.peek()>c){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()&&c=='0')
            continue;
        stack.push(c);
    }
    for(int i=0;i<k;i++){
        if(!stack.isEmpty())
            stack.pop();
    }
    StringBuilder sb= new StringBuilder();
    if(stack.isEmpty())
        return "0";
    while(!stack.isEmpty()){
        sb.append(stack.pop());
    }
    return sb.reverse().toString();
}
}
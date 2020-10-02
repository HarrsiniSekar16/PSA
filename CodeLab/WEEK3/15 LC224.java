class Solution {
      public int calculate(String s) {
        int[] exprIndexPtr = new int[]{0};
        String wrapped = "(" + s + ")";
        return compute(wrapped.toCharArray(), exprIndexPtr);
    }

    private int compute(char[] sChars, int[] idx) {
        Stack<Integer> nums = new Stack<>();
        
        int num = 0, sign = 1;
        for(;idx[0] < sChars.length; idx[0]++) {
            int i = idx[0];
            
            if(Character.isDigit(sChars[i])) {
                num = num * 10 + sChars[i] - '0';

            } else if(sChars[i] == ' ') {
                continue;
            
            } else if(sChars[i] == '+') {
                nums.push(sign * num);
                sign = 1;
                num = 0;
            
            } else if(sChars[i] == '-') {
                nums.push(sign * num);
                sign = -1;
                num = 0;
            
            } else if(sChars[i] == '(') {
                ++idx[0];
                nums.push(sign * compute(sChars, idx));
            
            } else if(sChars[i] == ')') {
                break;
            
            }
        }

        int result = sign * num;
        
        while(!nums.isEmpty()) {
            result += nums.pop();
        }
        
        return result;
    }
}
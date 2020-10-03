class Solution {
    public String decodeAtIndex(String S, int K) {
        Stack<long[]> stack=new Stack();
        stack.add(new long[4]);
        long[] pre=new long[4];
        long[] peek=stack.peek();
        for(int i=0;i<S.length();i++){
            peek=stack.peek();
            char ch = S.charAt(i);
            if(ch >='a' && ch<='z'){
                peek[1] = peek[1]+1;
                peek[2] = peek[2]+1;
                peek[3] = peek[3]+1;
            }else{
                long c = 1;
                while(i<S.length()){
                    ch = S.charAt(i);
                    if(!Character.isDigit(ch)){
                        i--;
                        break;
                    }
                    c *= (int)(ch-'0');
                    i++;
                }
                peek[2]=peek[1]+pre[3];
                peek[3]=c*peek[2];
                if(peek[3]>=K || i+1==S.length()-1)break;
                long[] newPeek = new long[4];
                newPeek[0] = i+1;
                stack.add(newPeek);
                pre = peek;
            }
        }
        if(K>peek[3])return "";
        long modules = K;
        while(!stack.isEmpty()){
            long[] top = stack.pop();
            modules = modules%top[2];
            if(modules==0)
                return String.valueOf(S.charAt((int)(top[0]+top[1]-1)));
            if(stack.isEmpty()){
                return String.valueOf(S.charAt((int)(top[0]+modules%top[1]-1)));
            }
            long[] newTop = stack.peek();
            if(modules>newTop[3]){
                modules = modules-newTop[3];
                return String.valueOf(S.charAt((int)(top[0]+modules%top[1]-1)));
            }
        }
        return "";
    }
}
class Solution {
    public int scoreOfParentheses(String S) {
        HashMap<Integer, Integer> map=new HashMap<>();
    int lb=0;
    
    char[]s=S.toCharArray();
    
    int score=0;
    
    for(int i=0;i<s.length;i++){
        if(s[i]=='('){
            lb++;
        }else{
            int temp2=0;
            if(map.get(lb)==null){
                temp2=1;
                lb--;
            }else{
                temp2=2*map.get(lb);
                map.remove(lb);
                lb--;
            } 
            
            
            if(lb>0){
                    
                if(map.get(lb)==null){
                    map.put(lb, temp2);
                }else{
                    int temp1=map.get(lb);
                    map.put(lb, temp1+temp2);
                }
            }else score+=temp2;
            
            
        }
    }
    
    return score;
    
    
    }
}
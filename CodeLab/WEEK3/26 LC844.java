class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1, j = T.length()-1, del1 = 0, del2 = 0;
        while(j>=0 || i>=0){
            if(i>=0 && S.charAt(i)=='#' || j>=0 && T.charAt(j)=='#'){
                while(i>=0 && S.charAt(i) == '#'){
                    del1++;
                    i--;
                }
                while(j>=0 && T.charAt(j) == '#'){
                    del2++;
                    j--;
                }
                while(i>=0 && S.charAt(i)!='#' && del1!=0){
                    i--;
                    del1--;
                }
                while(j>=0 && T.charAt(j)!='#' && del2!=0){
                    j--;
                    del2--;
                }
            }
            else{
				//case where one index is less than 0 and one is not
                if(i<0 ^ j<0 || S.charAt(i)!=T.charAt(j)){
                    return false;
                }
                i = (i>=0)?i-1:i;
                j = (j>=0)?j-1:j;
            }
        }
        return true;
    }
}
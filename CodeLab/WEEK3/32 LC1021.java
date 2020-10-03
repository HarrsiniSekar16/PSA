class Solution {
    public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        
        for (char ch: S.toCharArray()) {
            sb.append(ch);
            count += ch == '(' ? 1 : -1;

            if (count == 0) {
                res.append(sb.substring(1, sb.length() - 1));
                sb = new StringBuilder();
            }
        }
        
        return res.toString();
    }
}
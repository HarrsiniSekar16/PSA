class Solution {
    public String simplifyPath(String path) {
        if(path.isEmpty()) return "";//return empty if path is empty
        String[] str=path.split("\\/+"); // splitting the string using regular expression
        StringBuilder ans=new StringBuilder();
        Stack<String> st=new Stack<>();
        for(int i=0;i<str.length;i++)
        {
            if(str[i].equals(".."))
            {
                if(!st.isEmpty())
                st.pop(); // if current string is .. and there is any root directory then pop it
            }
            else if(str[i].equals("."))
            {
                continue;
            }
            else
            {
                st.push(str[i]);// push the valid directory to stack
            }
        }
        while(!st.isEmpty())
        {
            if(!st.peek().isEmpty())
            ans.insert(0,"/"+st.peek());
            st.pop();
        }
        return ans.length()==0?"/":ans.toString();
    }
}
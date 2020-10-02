class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr=new ArrayList();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }

        Stack<Integer> s=new Stack<>();

        int[] ans=new int[arr.size()];
        ans[arr.size()-1]=0;
        
        s.push( arr.get(arr.size()-1));
        
        for(int i=arr.size()-2;i>=0;i--){
            if(arr.get(i)<s.peek()){
                ans[i]=s.peek();
            }else{
                while(!s.isEmpty() && arr.get(i)>=s.peek()){
                    s.pop();
                }
                if(s.size()==0){
                    ans[i]=0;
                }else{
                    ans[i]=s.peek();
                }
            }
            s.push(arr.get(i));
        }
        return ans;
    }
}
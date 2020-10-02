class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        
        ListNode[] bucket = new ListNode[k];
        int len = calcLen(root);
        int equal = len / k;
        int rem = len % k;
        int temp_equal=equal, i=0;
        if(rem>0) temp_equal+=1; rem--;
        ListNode curr = root;
        while(curr!=null){
            temp_equal--;
            if(temp_equal==0){
                bucket[i++] = root;
                root = curr.next;
                curr.next = null;
                curr = root;
                temp_equal=equal;
                if(rem>0) temp_equal+=1; rem--;
            }
            else curr = curr.next;
        }
        return bucket;
    }
    
    int calcLen(ListNode root){
        int len=0;
        while(root!=null){len++; root=root.next;}
        return len;
    
    
    }
}
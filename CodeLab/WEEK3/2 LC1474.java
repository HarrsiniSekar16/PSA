class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
                ListNode curr = head;
        while(curr!=null) {
            ListNode mthNode = getMthNode(curr, m);
            if(mthNode==null) {
                return head;
            }
            curr = deleteNNodes(mthNode.next,n);
            mthNode.next = curr;
        }
        return head;
    }
    private ListNode getMthNode(ListNode curr, int m) {
        for(int i=0;i<m-1 && curr!=null; i++) {
            curr = curr.next;
        }
        return curr;
    }
    private ListNode deleteNNodes(ListNode curr, int n) {
        for(int i=0;i<n && curr!=null;i++) {
            curr = curr.next;
        }
        return curr;
    }
}
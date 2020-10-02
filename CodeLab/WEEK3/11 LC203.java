class Solution {
    public ListNode removeElements(ListNode head, int val) {
         ListNode curr = new ListNode(0);
		ListNode res = curr;
		while(head!=null)
		{
			if(head.val!=val)
			{ 
				curr.next=new ListNode(head.val);
				curr=curr.next;	
			}
			head=head.next;
		}
	 	return res.next;
    }
}
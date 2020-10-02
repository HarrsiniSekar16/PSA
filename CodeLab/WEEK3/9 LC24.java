class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        
        ListNode temp = head;
        ListNode prev = head;
        head = head.next;
        
        while(temp != null && temp.next != null){
            ListNode temp2 = temp.next.next; 
            temp.next.next = temp; 
            prev.next = temp.next;
            temp.next = temp2;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    
}

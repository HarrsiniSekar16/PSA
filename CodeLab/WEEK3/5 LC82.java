class Solution {
    public ListNode deleteDuplicates(ListNode head) {
         ListNode current = head;
        ListNode next = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode node = prev;
        
        while(next != null) {
            int count = 0;
            while(next != null && current.val == next.val) {
                next = next.next;
                count++;
            }
            
            if (count > 1) {
                prev.next = next;
                current = next;
            } else {
                prev = current;
                current = next;
            }
        }
        
        return node.next;
    
    }
}
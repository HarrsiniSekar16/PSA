class Solution {
    public void reorderList(ListNode head) {
if (head == null) return;

        ListNode slow = head,
                    fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        ListNode curr = slow.next,
                    prev = null;
        
        slow.next = null;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        
        ListNode rev = prev; 
        curr = head;
        
        while (rev != null) {
            ListNode currNextTemp = curr.next;
            curr.next = rev;
            rev = rev.next;
            curr.next.next = currNextTemp;
            curr = currNextTemp;
        
}
    }
}
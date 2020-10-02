class Solution {
 private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        
        while (k > 0 && cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k--;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (head != null) {
            ListNode ptr = head;
            int count = 0;
            
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            if (count == k) {
                ListNode revHead = reverseLinkedList(head, k);
                prev.next = revHead;
                
                prev = head;
            } else {
                prev.next = head;
            }

            head = ptr;
        }
        return dummy.next;
    }
}
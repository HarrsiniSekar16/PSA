class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        
        //Some inits
        ListNode oddi = new ListNode(0);
        ListNode oddHead = oddi;
        ListNode eveni = new ListNode(0);
        ListNode evenHead = eveni;
        int i = 0;
        
        while (head != null){
            if (i%2 == 0){
                oddi.next = head;
                oddi = oddi.next;
            }
            else{
                eveni.next = head;
                eveni = eveni.next;
            }
            head = head.next;
            i++;
        }
        eveni.next = null;
        
        oddi.next = evenHead.next;
        return oddHead.next;
    
    }
}
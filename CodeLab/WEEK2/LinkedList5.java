import java.util.*;

public class LinkedList5 {
	ListNode tail = null;
	 ListNode start = null;
	public int getDecimalValue(ListNode head) {
	       List<Integer> list  = new ArrayList<>();
	       while(head!=null){
	           list.add(head.val);
	           head = head.next;
	       }
	        int res = 0;
	        for(int i=list.size()-1;i>=0;i--){
	            res+=list.get(i)*Math.pow(2,(list.size()-1)-i);
	        }
	        return res;
	}
	
	 public void add(int data){  
	     ListNode newNode = new ListNode(data);  
        if(start== null) {    
            start = newNode;  
            tail = newNode;   
        }  
        else {    
            tail.next = newNode;    
            tail = newNode;      
        }  
	 }
	
	public static void main(String[] args) {
		BinaryToInteger obj = new BinaryToInteger();
		int [] arr = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
		for(int i=0;i<arr.length;i++) {
			obj.add(arr[i]);
		}
		int res = obj.getDecimalValue(obj.start);
		System.out.println("Decimal value is:"+res);
	}
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
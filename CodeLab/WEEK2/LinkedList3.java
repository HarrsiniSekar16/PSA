// Java program to partition a linked list 
// around a given value. 
class LinkedList3 { 


static class Node 
{ 
	int data; 
	Node next; 
} 

static Node newNode(int data) 
{ 
	Node new_node = new Node(); 
	new_node.data = data; 
	new_node.next = null; 
	return new_node; 
} 

static Node partition(Node head, int x) 
{ 

	Node tail = head; 

	Node curr = head; 
	while (curr != null) 
	{ 
		Node next = curr.next; 
		if (curr.data < x) 
		{ 
			/* Insert node at head. */
			curr.next = head; 
			head = curr; 
		} 

		else 
{
			tail.next = curr; 
			tail = curr; 
		} 
		curr = next; 
	} 
	tail.next = null; 

	return head; 
} 


static void printList(Node head) 
{ 
	Node temp = head; 
	while (temp != null) 
	{ 
		System.out.print(temp.data + " "); 
		temp = temp.next; 
	} 
} 


public static void main(String[] args) 
{ 
	/* Start with the empty list */
	Node head = newNode(3); 
	head.next = newNode(5); 
	head.next.next = newNode(8); 
	head.next.next.next = newNode(2); 
	head.next.next.next.next = newNode(10); 
	head.next.next.next.next.next = newNode(2); 
	head.next.next.next.next.next.next = newNode(1); 

	int x = 5; 
	head = partition(head, x); 
	printList(head); 
} 
} 




import java.util.*; 
import java.lang.*; 
import java.io.*; 

class LinkedList4
{ 
	

static class Node 
{ 
	Node next; 
	int data; 
}; 


static Node create() 
{ 
	Node new_node = new Node(); 
	new_node.next = null; 

	return new_node; 
} 


static Node find_head(Node random) 
{ 
	// If the list is empty 
	if (random == null) 
		return null; 

	Node head, var = random; 

	while (!(var.data > var.next.data || 
						var.next == random)) 
	{ 
		var = var.next; 
	} 


	return var.next; 
} 


static Node sortedInsert(Node head_ref, 
						Node new_node) 
{ 
	Node current = head_ref; 


	if (current == null) 
	{ 
		new_node.next = new_node; 
		head_ref = new_node; 
	} 


	else if (current.data >= new_node.data) 
	{ 


		while (current.next != head_ref) 
			current = current.next; 
		current.next = new_node; 
		new_node.next = head_ref; 
		head_ref = new_node; 
	} 

	else
	{ 

		while (current.next != head_ref && 
			current.next.data < new_node.data) 
		{ 
			current = current.next; 
		} 
		new_node.next = current.next; 
		current.next = new_node; 
	} 


	return head_ref; 
} 

static void printList(Node start) 
{ 
	Node temp; 

	if (start != null) 
	{ 
		temp = start; 
		do
		{ 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} while (temp != start); 
	} 
} 


public static void main(String args[]) 
{ 

	int arr[] = { 12, 56, 2, 11, 1, 90 }; 
	int list_size, i; 

	Node start = null; 
	Node temp; 


	for (i = 0; i < 6; i++) 
	{ 


		if (start != null) 
			for (int j = 0; 
					j < (Math.random() * 10); j++) 
				start = start.next; 

		temp = create(); 
		temp.data = arr[i]; 
		start = sortedInsert(find_head(start), temp); 
	} 


	printList(find_head(start)); 
} 
} 



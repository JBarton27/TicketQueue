/*
 * The class uses the Queue data structure to store ticket information along with implementing the data as a collection of Nodes in the form of a linkedlist
 * 
 */

public class Queue {
	private Node first;
	private Node last;
	private int length;

class Node {
	String value;
	Node next;
	Node(String value) {
	 this.value = value;
	}
}

public Queue(String value) {
	Node newNode = new Node(value);
	first = newNode;
	last = newNode;
	length ++;
}

public void createTicket(String value) {
	Node newNode = new Node(value);
	if(length == 0) {
	first = newNode;
	last = newNode;
	}
	else {
	last.next = newNode;
	last = newNode;
	}
	length++;
}

public String removeTicket() {
	if(length == 0) {
	return null;
	}
	Node temp = first;
	
	if(length == 1) {
	first = null;
	last = null;
	}
	
	else {
	first = first.next;
	temp.next = null;
	}
	
	length --;
	return temp.value;	
}

public void getFirstTicket() {
	System.out.println("First ticket in Queue: " + first.value);
}

public void getLastTicket() {
	System.out.println("Last ticket in Queue: " + last.value);
}

public void getLength() {
	System.out.println("Length of Queue: " + length);
}

// returns the position of a specific ticket given its exact description
	public int positionInQueue(String issueDescription) {
		if(length == 0) {
		System.out.println("There are no tickets open");
		return 0;
	}
		else {
		Node temp = first;
		int i = 1;
		
		while(temp != null) {
			if(temp.value.equals(issueDescription)) {
				System.out.println("Your position in the Queue is " + i);
                return i; // Return the position when found
		} 	
		temp = temp.next;
		i++;
		}
		// If the loop ends without finding the value
        System.out.println("The issue is not found in the queue.");
        return -1; // Indicate that the issue was not found
		}
	}
}

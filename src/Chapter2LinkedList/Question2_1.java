package Chapter2LinkedList;

import java.util.Hashtable;


public class Question2_1 {

	public static void main(String[] args) {
		Node linkedlist = new Node("F");
		linkedlist.appendToTail("O");
		linkedlist.appendToTail("L");
		linkedlist.appendToTail("L");
		linkedlist.appendToTail("O");
		linkedlist.appendToTail("W");
		linkedlist.appendToTail(" ");
		linkedlist.appendToTail("U");
		linkedlist.appendToTail("P");
		display(linkedlist);
		removeDuplicates(linkedlist);
		display(linkedlist);
	}
	
	/*
	 * Description: Remove duplicates from an unsorted linked list, use extra buffer -- a hashtable 
	 * to remove any duplicates
	 * @param 
	 * @param
	 * @param
	 * @return 
	 */
	public static void removeDuplicates(Node l){
		Hashtable<String, Boolean> table = new Hashtable<String, Boolean>(); 
		Node previous = null;
		while(l != null){
			if ( table.containsKey(l.data)){
				previous.next = l.next; /*previou foward 2 nodes*/
			}else{
				table.put(l.data, true);
				previous = l; /*previous foward 1 node*/
			}
			l = l.next; /*l foward*/
		}
	}
	static void display(Node head){
		Node n = head;
		System.out.println("Linked List displaying:");
		if (n.next == null){
			System.out.print("Empty Linked List!");
		}
		while( n.next != null){
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
}

class Node{
	Node next = null;
	String data;
	public Node(String d){
		data = d;
	}
	void appendToTail(String d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){n=n.next;}
		n.next = end;
	}
	Node deleteNode(Node head, String d){
		Node n = head;
		if (n.data.equals(d)){
			return head.next; /*move head*/
		}
		while(n.next != null) {
			if (n.next.data.equals(d)){
				n.next = n.next.next;
				return head; /*head didn't change*/
			}
			n = n.next;
		}
		return head;
	}

}
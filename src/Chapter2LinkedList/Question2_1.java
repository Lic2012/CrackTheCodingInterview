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
		Node.display(linkedlist);
		//removeDuplicates(linkedlist);
		removeDuplicatesNoBuffer(linkedlist);
		Node.display(linkedlist);
	}
	
	/*
	 * Description: Remove duplicates from an unsorted linked list, use extra buffer -- a hashtable 
	 * to remove any duplicates
	 * @arg Hashtable table:the key is node's data , value is true or false indicates occour or not   
	 * @arg Node previous: the previous node pointer
	 * @param Node l: head not of linkedlist
	 * @return void
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
	/*
	 * Description: Not us extra buffer, Remove duplicates from an unsorted linked list
	 * 
	 */
	public static void removeDuplicatesNoBuffer(Node head){
		if (head == null) return;
		Node previous = head;
		Node current = head;
		while(current != null){
			Node runner= head;
			while(runner != current){
				if (runner.data.equals(current.data)){
					Node tmp = current.next;
					previous.next = tmp;
					current = tmp;
					break;
				}
				runner = runner.next;
			}
			if( runner == current ){
				previous = current;
				current = current.next;
			}
		}
	}
	
	/*
	 * Description: display the linked list like the following format: "F->O->L->L->O->W-> ->U->P"
	 */
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
package Chapter2LinkedList;
/*
 * Implement an algorithm to find the nth to last element of a singly linked list.
 */
public class Question2_2 {

	public static void main(String[] args) {
		Node1 linkedlist = new Node1("F");
		linkedlist.appendToTail("O");
		linkedlist.appendToTail("L");
		linkedlist.appendToTail("L");
		linkedlist.appendToTail("O");
		linkedlist.appendToTail("W");
		linkedlist.appendToTail(" ");
		linkedlist.appendToTail("U");
		linkedlist.appendToTail("P");
		Node.display(linkedlist);
		// to write method here:
		System.out.println(Node1.nthFromHead(linkedlist, 5).data);
		System.out.println(Node1.nthFromTail(linkedlist, 4).data);
	}
}
/*
 * Description : nth elements from the head of the singly linked list
 * @method Node nthFromHead(Node head, int n)
 * @method Node nthFromTail(Node head, int n)
 */
class Node1 extends Node{
	public Node1(String d){
		super(d);
	}
	/*
	 * Description: nth element from HEAD of the singly linked list
	 */
	public static Node nthFromHead(Node head, int n ){
		Node now = head;
		int count = 1;
		while (now!=null){
			if (count == n){
				return now;
			}
			now = now.next;
			count ++;
		}
		return null;
	}
	/*
	 * Description: nth element fro TAIL fo the singly linked list 
	 */
	public static Node nthFromTail(Node head , int n){
		Node p1 = head;
		Node p2 = head;
		for(int i = 1; i < n-1; i++){
			if ( p1.next == null ){
				return null;
			}
			p1 = p1.next;
		}
		p1 = p1.next;
		while(p1.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}

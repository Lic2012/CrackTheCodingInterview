package Chapter2LinkedList;

/*
 * You have two numbers represented by a linked list, where each node contains a sin-
 gle digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
 the list. Write a function that adds the two numbers and returns the sum as a linked
 list.
 *EXAMPLE
 *Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 *Output: 8 -> 0 -> 8
 */
public class Question2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node d1 = new Node("9");
		d1.appendToTail("2");
		d1.appendToTail("5");
		Node d2 = new Node("1");
		d2.appendToTail("8");
		d2.appendToTail("5");
		Node digit = plusTwoDigit(d1, d2);
		Node.display(digit);
	}
	/*
	 * A bug have program : if 1->8 + 2->2->2 then may be occour a error
	 */
	public static Node plusTwoDigit(Node a, Node b){
		int add1 =  0; 
		int add2 =  0;
		int add3 =  0;
		Node n;
		Node head; 
		Node n1 = a;
		Node n2 = b;
		int tmp1 = Integer.parseInt(n1.data)+ Integer.parseInt(n2.data);
		if (tmp1 >= 10){
			tmp1 = tmp1 -10;
			add1 = 1;			
		}
		head = n = new Node(tmp1 + "");
		n1 = n1.next;
		n2 = n2.next;
		int tmp2 = Integer.parseInt(n1.data) + Integer.parseInt(n2.data) + add1;
		if (tmp2 >= 10){
			tmp2 = tmp2 - 10;
			add2 = 1;
		}
		n.appendToTail(tmp2 + "");
		n1 = n1.next;
		n2 = n2.next;
		int tmp3 = Integer.parseInt(n1.data) + Integer.parseInt(n2.data) + add2;
		if (tmp3 >= 10){
			tmp3 = tmp3 - 10;
			add3 = 1;
		}
		n.appendToTail(tmp3 +"");
		if (add3 == 1){
			n.appendToTail("1");
		}
		return head;
	}

}

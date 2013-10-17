package Chapter3StackQueue;


public class StackTry {
	Node top ;
	Node pop(){
		if (top == null	) return null;
		else{
			Node item = top;
			top = top.next;
			return item;
		}
	}
	void push(Object item){
		Node t = new Node(item);
		t.next = top;
		top = t;		
	}
	void display(){
		Node.display(top);
	}
}

class Node{
	Node next = null;
	Object data;
	String datas;
	Node(Object data){
		this.data = data;
	}
	static void display(Node head){
		Node n = head;
		System.out.println("Linked List displaying:");
		if (n == null){
			System.out.print("Empty Linked List!");
		}
		while( n.next != null){
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data); /*display the last one*/
	}
}
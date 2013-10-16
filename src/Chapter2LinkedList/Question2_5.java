package Chapter2LinkedList;

public class Question2_5 {
	public static void main(String[] args){
		Node circlelist = new Node("A");
		circlelist.appendToTail("B");
		circlelist.appendToTail("C");
		Node firstnode = circlelist;
		firstnode = firstnode.next.next;
		circlelist.appendToTail("D");
		circlelist.appendToTail("E");
		circlelist.appendToTail("F");
		Node runner = firstnode.next.next.next;
		runner.next = firstnode;
		//Node.display(circlelist);
		System.out.println(isCircleLinkedList(circlelist));
	}
	public static boolean isCircleLinkedList(Node head){
		Node p1 = head;
		Node p2 = head;
		if (p1.next == null || p2.next == null){
			return false;
		}else if(p2.next.next == null) return false;
		while(p1.next!=null && p2.next!=null){
			if(p2.next.next == null) return false;
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1==p2) return true;
		}
		return false;
	}
}

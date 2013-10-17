package Chapter3StackQueue;

import Chapter3StackQueue.Node;

public class QueueTry {
	Node first, back;
	void inQueue(Object item){
		if (first == null){
			back = new Node(item);
			first = back;
		}else{
			back.next = new Node(item);
			back = back.next;
		}
	}
	Node deQueue(){
		if (first != null){
			Node item = first;
			first = first.next;
			return item;
		}
		return null;
	}
	
	void display(){
		Node.display(first);
	}
}

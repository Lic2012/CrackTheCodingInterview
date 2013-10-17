package Chapter3StackQueue;

public class Question3_1 {

	public static void main(String[] args) {
		Stack1 stack1 = new Stack1();
		stack1.push(1);
		stack1.push(2);
		stack1.push(4);
		stack1.push(3);
		stack1.push(5);
		System.out.println(stack1.pop().data);
	}

}

class Stack1 extends StackTry{
	void push(int item){
		Node add = new Node(item);
		if( item <= (int)top.data){
			add.next = top;
			top = add;
		}else{
			add.next = top.next;
			top.next = add;
		}
	}
}
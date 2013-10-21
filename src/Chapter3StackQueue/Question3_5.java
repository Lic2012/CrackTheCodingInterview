package Chapter3StackQueue;

import java.lang.reflect.Array;
import java.util.Stack;

public class Question3_5 {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.inQueue(1);
		queue.inQueue(2);
		queue.inQueue(3);
		queue.inQueue(4);
		queue.inQueue(5);
		queue.display();
		queue.deQueue();
		queue.display();
		queue.deQueue();
		queue.display();
		queue.inQueue(6);
		queue.display();
	}

}
/*
 * this class is far from perfect! cuz USE MyQueue(T) to identify the type of Stack elements!
 */
class MyQueue{
	private Stack stack1 = new Stack(); // use private decoration The external class cannot access！
	private Stack stack2 = new Stack(); // error:  havn't been instanced

	public void inQueue(Object item){
		stack1.push(item);
	}
	public Object deQueue(){
		if(stack1.isEmpty() && stack2.isEmpty()) return null;
		else{
			while(!stack1.isEmpty()) stack2.push(stack1.pop());
			Object peek = stack2.pop();
			while(!stack2.isEmpty()) stack1.push(stack2.pop());
			return peek;
		}
	}
	public Stack getStack1(){ // 
		return this.stack1;
	}
	public Stack getStack2(){
		return this.stack2;
	}
	public void display(){
		Object[] arr = stack1.toArray();
		for(Object ele: arr){
			System.out.print(ele.toString()+"-->");
		}
		System.out.println();
	}
	
}
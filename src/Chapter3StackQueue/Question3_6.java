package Chapter3StackQueue;

import java.util.*;

public class Question3_6 {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(1);
		s.push(2);
		display(s);
		Stack<Integer> s2 = method1(s);
		display(s2);
		
		
	}
	
	private static Stack<Integer> method1(Stack<Integer> stack1){
		Stack<Integer> stack2 = new Stack<Integer>();
		while(!stack1.isEmpty()){
			Integer tmp = stack1.pop();
			while (!stack2.isEmpty() && tmp > stack2.peek()){
				stack1.push(stack2.pop());
			}
			stack2.push(tmp);
		}
		return stack2;
	}
	public static void display(Stack<Integer> s1){
		Object[] arr = s1.toArray();
		for(Object ele: arr){
			System.out.print(ele.toString()+"-->");
		}
		System.out.println("end");
	}

}



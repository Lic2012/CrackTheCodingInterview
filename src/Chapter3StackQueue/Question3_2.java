package Chapter3StackQueue;

import java.util.*;

public class Question3_2 {

	public static void main(String[] args) {
		StackSets s = new StackSets(3);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
	}
}

class StackSets extends Stack<Object>{
	int threshold;
	int current=0;
	Stack<Stack<Object>> topstack;
	public StackSets(int threshold){
		this.threshold = threshold;
		topstack = new Stack<Stack<Object>>();
		topstack.push(this);
	}
	
	public Object push(Object item){
		if (current==threshold){
			Stack<Object> s1 = new Stack<Object>();
			s1.push(item);
			topstack.push(s1);
			current = 0;
		}else{
			current ++ ;
			topstack.peek().push(item);
		}
		return null;
	}
	
	public Object pop(){
		if (topstack.peek().size() == 1){
			Object last = topstack.peek().peek();
			if (topstack.size() > 1){
				topstack.pop();
			}
			return last;
		}else{
			return topstack.peek().pop();
		}
	}
}
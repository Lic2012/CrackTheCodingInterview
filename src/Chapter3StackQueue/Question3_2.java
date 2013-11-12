package Chapter3StackQueue;

import java.util.*;
/*
 * @description: design a stack
 * @function: Min which returns the minimum element. Push, pop and Min should all operate in O(1) time 
 * @improve: if the condition is 1,1,1.... the storage is a waste. try to improve ! try to set count on stack_min
 */
public class Question3_2 {
	public static void main(String[] args){
		stack3_2 s = new stack3_2();
		s.push(2);
		System.out.println(s.getMin());
		System.out.println(s.peek());
		s.push(1);
		s.push(10);
		s.push(3);
		s.push(8);
		s.push(4);
		System.out.println(s.getMin());
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.getMin());
		System.out.println(s.peek());
		s.pop();
		s.pop();
		s.pop();
		System.out.println(s.getMin());
		System.out.println(s.peek());
		System.out.println(s.getMin());
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.getMin());
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.getMin());
		System.out.println(s.peek());
	}
}

/*
 *@Description: design a stack can push pop and return Min value. 
 */

class stack3_2 {
	private Stack<Integer> stack_min = new Stack<Integer>(); //minimum values 
	private Stack<Integer> stack_body = new Stack<Integer>(); //body stack
	public void push(int n){
		System.out.println("In: " + n);
		stack_body.push(n); // whatever situation, add n to body_stack
		if (stack_min.isEmpty()) stack_min.push(n); // if empty stack, add n directly to min_stack
		else{
			if (n<stack_min.peek()) stack_min.push(n); // if n is smaller than min, add n to min_stack
			else stack_min.push(stack_min.peek()); // ! Can Improve if n is larger, add min to min_stack. but may cause storage loss
		}
	}
	public Integer pop(){ //pop 2 stacks
		try {
			stack_min.pop();
			System.out.println("Out: " + stack_body.peek());
			return stack_body.pop();
		}
		catch(Exception EmptyStackException){
			System.out.println("Empty Stack can't pop!");		
		}
		return null;
	}
	public Integer getMin(){// get the minimum value of body stack, use O(1) 
		System.out.print("Min: ");
		try{
			return stack_min.peek();
		}
		catch(Exception EmptyStackException){
			System.out.println("Empty Stack, no elements!");
		}
		return null;
	}
	public Integer peek(){ //get the peek element of the body stack
		System.out.print("Peek: ");
		try{
			return stack_body.peek();
		}
		catch(Exception EmptyStackException){
			System.out.println("Empty Stack, no elements!");
		}
		return null;
	}
}
/*
 * stack_min node
 * when push:
 * if stack_min = null  then set n to minNode.value  and push minNode to stack_min; push n to stack_body
 * else{
 *   if n<stack_min.peek.value then set n to minNode.value  and push minNode to stack_min
 *   else stack_min.peek.cnt++ 
 *   stack_body.push(n)
 * when pop:
 * if stack_body == null return null;
 * else
 * 	if stack_min.peek.cnt > 1
 * 		stack_min.peek.cnt--

 * 	else stack_min.pop();
 *  return stack_body.pop();
 * when peek:
 * similar as origin
 * when getMin:
 * return stack_min.peek.value
 */
class minNode{
	int value;
	int cnt = 1;
}

//	public static void main(String[] args) {
//		StackSets s = new StackSets(3);
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		s.push(4);
//		s.push(5);
//		s.push(6);
//		s.push(7);
//		s.push(8);
//		s.popAt(4);
//		while (s.size()>0)
//			System.out.println(s.pop());
//
//	}
//}
//
//class StackSets extends Stack<Object>{
//	int threshold;
//	int current=0;
//	int arraylength=0;
//	ArrayList <Object> array;
//	Stack<Stack<Object>> topstack;
//	public StackSets(int threshold){
//		this.threshold = threshold;
//		topstack = new Stack<Stack<Object>>();
//		topstack.push(this);
//	}
//	
//	public Object push(Object item){
//		if (current==threshold){
//			Stack<Object> s1 = new Stack<Object>();
//			s1.push(item);
//			topstack.push(s1);
//			current = 0;
//		}else{
//			current ++ ;
//			topstack.peek().push(item);
//		}
//		toAnArray(item);
//		return null;
//	}
//	
//	public Object pop(){
//		if (topstack.peek().size() == 1){
//			Object last = topstack.peek().peek();
//			if (topstack.size() > 1){
//				topstack.pop();
//			}
//			removeFromArray(arraylength-1);
//			return last;
//		}else{
//			removeFromArray(arraylength-1);
//			return topstack.peek().pop();
//		}
//	}
//	
//	public void toAnArray(Object item){
//		array.add(item);
//		arraylength++;
//	}
//	public void removeFromArray(int index){
//		array.remove(index);
//		arraylength--;
//	}
//	
//	public Object popAt(int index){
//		Object value = null;
//		if(index >= arraylength){
//			System.out.println("index out of range!");
//		}else{
//			value = array.get(index);
//			array.remove(index);
//		}
//		return value;
//	}
//	
//	public StackSets generateStack(ArrayList<Object> arr){
//		StackSets newstack = new StackSets(threshold);
//		for(int i = 0 ; i< array.size(); i++)
//			newstack.push(array.get(i));
//		return newstack;
//	}
//	
//	public void refresh(StackSets s){
//		s = generateStack(array);
//	}
//}
//
//class SetOfStacks{
//	ArrayList<Stack> stacks = new ArrayList<Stack>();
//	public int capicity;
//	public SetOfStacks(int capicity){ this.capicity = capicity;}
//	
//	public Stack getLastStack(){
//		if(stacks.size() == 0) return null;
//		return stacks.get(stacks.size()-1);
//	}
//	
//	public void push(int v){/*see earlier code*/
//		Stack last = getLastStack();
//		if (last!=null) last.push(v);
//		else{
//			Stack stack = new Stack(capacity);
//			
//		}
//	}
//	
//}
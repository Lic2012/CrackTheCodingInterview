package Chapter3StackQueue;

import java.util.Stack;

public class Question3_1 {

	public static void main(String[] args) {
		StackwithMin stackMin = new StackwithMin();
		stackMin.push(2);
		stackMin.push(3);
		stackMin.push(4);
		stackMin.push(3);
		stackMin.push(2);
		stackMin.push(1);
		stackMin.push(5);
		stackMin.push(6);
		stackMin.push(7);
		System.out.println(stackMin.pop());
		System.out.println(stackMin.min());
	}

}
class StackwithMin extends Stack<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Stack<Integer> s2;
	public StackwithMin(){
		s2 = new Stack<Integer>();
	}
	public void push(int i){
		if (i< this.min()){
			s2.push(i);
		}
		super.push(i);
	}
	public Integer pop(){
		int value = super.pop();
		if (value == min()){
			s2.pop();
		}
		return value;
	}
	public int min(){
		if (s2.isEmpty()) return  Integer.MAX_VALUE;
		else return s2.peek();
	}
}
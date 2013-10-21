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
		s.push(8);
		s.popAt(4);
		while (s.size()>0)
			System.out.println(s.pop());

	}
}

class StackSets extends Stack<Object>{
	int threshold;
	int current=0;
	int arraylength=0;
	ArrayList <Object> array;
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
		toAnArray(item);
		return null;
	}
	
	public Object pop(){
		if (topstack.peek().size() == 1){
			Object last = topstack.peek().peek();
			if (topstack.size() > 1){
				topstack.pop();
			}
			removeFromArray(arraylength-1);
			return last;
		}else{
			removeFromArray(arraylength-1);
			return topstack.peek().pop();
		}
	}
	
	public void toAnArray(Object item){
		array.add(item);
		arraylength++;
	}
	public void removeFromArray(int index){
		array.remove(index);
		arraylength--;
	}
	
	public Object popAt(int index){
		Object value = null;
		if(index >= arraylength){
			System.out.println("index out of range!");
		}else{
			value = array.get(index);
			array.remove(index);
		}
		return value;
	}
	
	public StackSets generateStack(ArrayList<Object> arr){
		StackSets newstack = new StackSets(threshold);
		for(int i = 0 ; i< array.size(); i++)
			newstack.push(array.get(i));
		return newstack;
	}
	
	public void refresh(StackSets s){
		s = generateStack(array);
	}
}

class SetOfStacks{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capicity;
	public SetOfStacks(int capicity){ this.capicity = capicity;}
	
	public Stack getLastStack(){
		if(stacks.size() == 0) return null;
		return stacks.get(stacks.size()-1);
	}
	
	public void push(int v){/*see earlier code*/
		Stack last = getLastStack();
		if (last!=null) last.push(v);
		else{
			Stack stack = new Stack(capacity);
			
		}
	}
	
}
package Chapter2LinkedList;

public class Question2_3 {

	public static void main(String[] args) {
		
	}
	
	public static boolean deleteMid(Node c){
		Node n = c.next;
		if (n == null || n.next == null) return false;
		c.data = n.data;
		c.next = n.next;
		return true;	
	}

}

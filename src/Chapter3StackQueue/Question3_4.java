package Chapter3StackQueue;

public class Question3_4 {

	public static void main(String[] args) {
		Hanoi han = new Hanoi();
		han.hanoi(3, 'A', 'B', 'C');
	}

}

class Hanoi{
	public void hanoi(int n,char src, char ass, char des){
		if (n == 1) move(src, des);
		else{
			hanoi(n-1, src, des, ass);
			move(src, des);
			hanoi(n-1, ass, src, des);
		}
	}
	public void move(char src, char des){
		System.out.println(src+"-->"+des);
	}
}
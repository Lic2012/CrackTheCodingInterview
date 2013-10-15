package Chapter1ArraysAndStrings;

/* Question: Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 * @method Boolean isRotation(String s1, String s2)
 * @method Boolean isSubstring(String a, String b) judge whether a is substring of b
 */
public class Question1_8 {

	public static void main(String[] args) {
		String input1a = "apple";
		String input1b = "pleap";
		System.out.println(isRotation(input1a, input1b));
		String input2b = "ppale";
		System.out.println(isRotation(input1a, input2b));
	}
	
	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		if ((len == s2.length()) && (len > 0)){
			String s1s1 = s1+s1;
			return isSubstring(s1s1, s2);
		}
		else return false;
	}
	
	public static boolean isSubstring(String a, String b){
		return a.contains(b);
	}

}

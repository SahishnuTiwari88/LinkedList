package stack;
import java.util.Stack;

public class ReverseUsingStack {
	
	public static String reverseString(String str) {
		char[] chars = str.toCharArray();
		Stack<Character> stk = new Stack<>(); 	
		String revStr = "";
		for(char ch : chars) {
			stk.push(ch);
		}
		for(int i = 0; i<chars.length; i++) {
			chars[i] = stk.pop();
			revStr = revStr+chars[i];
		}
		return revStr;
	}

	public static void main(String[] args) {
		System.out.println("Reverse string is : "+reverseString("Sarvesh Tiwari"));

	}

}

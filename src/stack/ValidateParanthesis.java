package stack;
import java.util.Stack;
public class ValidateParanthesis {

	public static boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray(); //({[]})
		for(char ch : chars) {
			if(ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}else {
				if(stack.isEmpty()) {  //in case we pass string staring with closing brackets as }
					return false;
				}else {
					char top = stack.peek();
					if((ch == '}' && top == '{') || (ch == ']' && top == '[') || (ch == ')' && top == '(')) {
						stack.pop();
					}else {
						return false;  //if stack is not empty
					}
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String str = "({[]})";
		boolean valid = isValid(str);
		System.out.println("Given paranthesis is Valid or Not : "+valid);

	}

}

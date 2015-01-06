public class Solution {
	public boolean isValid(String s) {
		Stack stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek().toString().charAt(0) == '(') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek().toString().charAt(0) == '[') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek().toString().charAt(0) == '{') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
package Level2;

import java.util.Stack;

public class RemovingPairs {

	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(ch);
				continue;
			} else {
				if (stack.peek() == ch) {
					stack.pop();
					continue;
				}
				stack.push(ch);
			}
		}
		if (stack.isEmpty())
			return 1;
		return 0;
	}
}
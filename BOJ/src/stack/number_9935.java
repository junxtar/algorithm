package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class number_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String boom = br.readLine();
		Stack<Character> stack = new Stack<>();
		Stack<Character> s = new Stack<>();
		char target = boom.charAt(boom.length() - 1);

		for (int i = 0; i < str.length(); i++) {
			char check = str.charAt(i);
			stack.push(check);
			if (stack.size() >= boom.length()) {
				if (target == check) {
					for (int j = boom.length() - 1; j >= 0; j--) {
						char boc = boom.charAt(j);
						if (boc == stack.peek()) {
							s.push(stack.peek());
							stack.pop();
						} else {
							while (!s.isEmpty()) {
								stack.push(s.pop());
							}
						}
					}
					s.clear();
				}
			}
		}
		if (stack.isEmpty()) {
			sb.append("FRULA");
		} else {
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
		}
		System.out.println(sb);
	}
}

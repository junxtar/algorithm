package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class number_4949 {

	public static String solution(String a) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (c == '(' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.empty() || stack.peek()!='(')
					return "no";
				else if (stack.peek() == '(')
					stack.pop();
			}else if (c == ']') {
					if (stack.empty() || stack.peek()!='[')
						return "no";
					else if (stack.peek() == '[')
						stack.pop();
				}

			}
			
		if (stack.empty())
			return "yes";
		else
			return "no";

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String write = br.readLine();
		while (!write.equals(".")) {
			sb.append(solution(write)).append("\n");
			write = br.readLine();
		}
		System.out.println(sb);

	}

}

package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class number_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			boolean is_temp = true;
			String temp = br.readLine();
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == '(') {
					stack.push(temp.charAt(i));
				} else if (stack.empty()) {
					sb.append("NO").append("\n");
					is_temp = false;
					break;
					
				} else {
					stack.pop();
				}
			}
			if (stack.empty() && is_temp) {
				sb.append("YES\n");
			}else if(!stack.empty()) {
				sb.append("NO").append("\n");
				
			}
			
			stack.clear();

		}

		System.out.println(sb);

	}

}

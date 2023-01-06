package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class number_1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));

		}

		int temp = 0;
		int num = 1;
		while (temp<n) {
			
			if (list.get(temp) >= num) {
				stack.push(num);
				num++;
				sb.append("+").append("\n");
			}
			if(stack.peek().equals(list.get(temp))) {
				stack.pop();
				temp++;
				sb.append("-").append("\n");
				if(temp==n)
					break;
			}
			if(stack.contains(list.get(temp))&&!stack.peek().equals(list.get(temp))) {
				break;
			}
			
		}
		if(!stack.empty())
			System.out.println("NO");
		else
			System.out.println(sb);
	}
}

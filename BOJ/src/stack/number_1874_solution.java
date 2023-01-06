package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class number_1874_solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer>stack = new Stack<>();
		 
		int count = 0;
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			while(count < num) {
				count++;
				stack.push(count);
				sb.append("+\n");
				
			}
			if(stack.empty() || stack.peek() < num) {
				sb.delete(0, sb.length());
				sb.append("NO");
				break;
			}
			while(!stack.empty()) {
				int pop_num = stack.pop();
				sb.append("-\n");
				if(pop_num == num)
					break;
			}
		}
		br.close();
		System.out.println(sb);
	}

}

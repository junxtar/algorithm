package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class number_9093 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character>stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();
				for(int i = 0; i<temp.length(); i++) {
					stack.push(temp.charAt(i));
				}
				while(stack.size()>0) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
		
	}

}

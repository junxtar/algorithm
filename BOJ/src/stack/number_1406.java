package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class number_1406 {
	
	static Stack<Character>stack = new Stack<>();
	static Stack<Character>s = new Stack<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str = br.readLine();
		for(int i = 0; i<str.length(); i++) {
			stack.push(str.charAt(i));
		}
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			String command = br.readLine();
			if(command.charAt(0) == 'P') {
				st = new StringTokenizer(command);
				command = st.nextToken();
				char word = st.nextToken().charAt(0);
				P(word);
			}else if(command.equals("L")) {
				L();
			}else if(command.equals("D")) {
				D();
			}else if(command.equals("B")) {
				B();
			}
		}
		
		while(!s.isEmpty()) {
			stack.push(s.pop());
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		sb.reverse();
		System.out.println(sb);
	}
	static void L() {
		if(stack.isEmpty()) {
			return;
		}else {
			s.push(stack.pop());
		}
	}
	static void D() {
		if(s.isEmpty()) {
			return;
		}else {
			stack.push(s.pop());
		}
	}
	static void B() {
		if(!stack.isEmpty()) {
			stack.pop();
		}else {
			return;
		}
	}
	static void P(char word) {
		stack.push(word);
	}
}

package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class number_17413 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str  = br.readLine();
		Stack<Character>s = new Stack<>();
		boolean set = false;
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c=='<') {
				while(!s.isEmpty()) {
					sb.append(s.pop());
				}
				set = true;
			}
			if(c==' ') {
				while(!s.isEmpty()) {
					sb.append(s.pop());
				}
				sb.append(c);
				continue;
			}
			
			if(c=='>') {
				sb.append(c);
				set = false;
				continue;
			}
			if(!set) {
				s.add(c);
			}else {
				sb.append(c);
			}
		}
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb);
	}

}

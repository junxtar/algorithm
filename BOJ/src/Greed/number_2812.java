package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class number_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String number = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < number.length(); i++) {
			int num = number.charAt(i) - '0';
			if (stack.isEmpty()) {
				stack.push(num);
				continue;
			} 
			while (!stack.isEmpty() && stack.peek() < num) {
				if (stack.size() + number.length() - (i + 1) < N - K) {
					break;
				}
				stack.pop();
			} 
			stack.push(num);
			
		}
		
		while (stack.size() != N - K) {
			stack.pop();
		}
		
		for (int value : stack) {
			sb.append(value);
		}
		System.out.println(sb.toString());
	}
}

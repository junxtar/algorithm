package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class number_10773 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer>stack = new Stack<>();
		int k = Integer.parseInt(br.readLine());
		while(k-->0) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0)
				stack.pop();
			else
				stack.push(num);
		}
		int result = 0;
		for(Integer data: stack) {
			result += data;
		}
		System.out.println(result);
		

	}

}

package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class number_10828 {
	
	public static int top(Stack<Integer>stack) {
		if(stack.empty())
			return -1;
		else
			return stack.peek();
	}
	public static int empty(Stack<Integer>stack) {
		if(!stack.empty())
			return 0;
		else
			return 1;
	}
	public static int pop(Stack<Integer>stack){
		if(stack.empty())
			return -1;
		else
			return stack.pop();
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer>stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String command = br.readLine();
			int num = 0;
			if(command.startsWith("push")) {
				num = Integer.parseInt(command.substring(5, command.length()));
				stack.push(num);
			}else if(command.equals("top")) {
				System.out.println(top(stack));
			}else if(command.equals("size")) {
				System.out.println(stack.size());
			}else if(command.equals("empty")) {
				System.out.println(empty(stack));
			}else if(command.equals("pop")) {
				System.out.println(pop(stack));
			}
				
		}
	}

}

package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class number_17298 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer>stack = new Stack<>();
		
		int a = Integer.parseInt(br.readLine());
		int[]arr = new int[a];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<a; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()){
			arr[stack.pop()] = -1;
		}
		for(int i = 0; i<a; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
		
	}

}

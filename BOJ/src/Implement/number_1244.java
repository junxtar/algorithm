package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1244 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[]arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			if(sex == 1) {
				man(arr, number);
			}else {
				woman(arr, number);
			}
		}
		print(arr);
	}
	
	static void man(int[]arr, int number) {
		for(int i = 1; i<arr.length; i++) {
			if(i % number == 0) {
				arr[i] = arr[i] == 0 ? 1 : 0;
			}
		}
	}
	
	static void woman(int[]arr, int number) {
		arr[number] = arr[number] == 0 ? 1 : 0;
		int start = number - 1;
		int end = number + 1;
		if(start == 0 || end == arr.length) 
			return;
		while(arr[start] == arr[end]) {
			arr[start] = arr[start] == 0 ? 1 : 0;
			arr[end] = arr[end] == 0 ? 1 : 0;
			start -= 1;
			end += 1;
			if(start == 0 || end == arr.length) 
				break;
		}
	}
	
	static void print(int[]arr) {
		for(int i = 1; i<arr.length; i++) {
			sb.append(arr[i]).append(" ");
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}

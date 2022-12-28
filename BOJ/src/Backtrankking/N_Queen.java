package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {
	static int N, count;
	static int[]arr;
	
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		count = 0;
		queen(0);
		System.out.println(count);
	}
	static void queen(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		for(int i = 0; i<N; i++) {
			arr[depth] = i;
			if(check(depth)) {
				queen(depth+1);
			}
		}
	}
	
	static boolean check(int column) {
		for(int i = 0; i<column; i++) {
			if(arr[i] == arr[column])
				return false;
			else if(Math.abs(i-column) == Math.abs(arr[i]-arr[column]))
				return false;
		}
		return true;
	}
}
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_9461 {
	static StringBuilder sb = new StringBuilder();
	static long[]arr = new long[101];
	
	public static long dp(int n) {
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for(int i = 4; i<=n; i++) {
			arr[i] = arr[i-3]+arr[i-2];
		}
		return arr[n];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp(n)).append("\n");
		}
		System.out.println(sb);
	}

}

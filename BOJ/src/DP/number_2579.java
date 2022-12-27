package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class number_2579 {
	static Integer[]dp;
	static int[]arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new Integer[n+1];
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
		}
		
		
		
		System.out.println(find(n));
		
	}
	static int find(int n) {
		dp[0] = arr[0];
		dp[1] = arr[1];
		if(n>=2) {
			dp[2] = arr[1]+arr[2];
		}
		for(int i = 3; i<=n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+arr[n-1])+arr[i];
		}
		return dp[n];
	}

}

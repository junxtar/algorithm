package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_2193 {
	static long dp[];
	static long dp(int n) {
		dp[1] = 1;
		if(n>1)
			dp[2] = 1;
		for(int i = 3; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
	
		return dp[n];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		dp = new long[n+1];
		System.out.println(dp(n));
	}

}

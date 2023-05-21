package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_1309 {

	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		System.out.println(solution());

	}
	static int solution() {
		dp[0] = 1;
		dp[1] = 3;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901; 
		}
		return dp[N];
	}
}

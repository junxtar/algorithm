package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_17626 {
	
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		System.out.println(solution(N));
	}
	
	static int solution(int N) {
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			if (Math.sqrt(i) % 1 == 0) {
				dp[i] = 1;				
			} else {
				dp[i] = i;
			}
			for (int j = 1; j <= (int)Math.sqrt(i); j++) {
				if (dp[i] > dp[i - j * j]) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}
		return dp[N];
	}
}

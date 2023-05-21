package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_2133 {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		System.out.println(search());
	}

	static int search() {
		if (N % 2 == 1) {
			return 0;
		}
		dp[0] = 1;
		dp[2] = 3;
		for (int i = 4; i <= N; i += 2) {
			dp[i] = dp[i - 2] * 4 - dp[i - 4];
		}
		return dp[N];

		// input= 2 answer = 3
		// input= 3 answer = 0
		// input= 4 answer = 11
		// input= 5 answer = 0
		// input= 6 answer = 41
		// input= 7 answer = 0
		// input= 8 answer = 153
	}
}

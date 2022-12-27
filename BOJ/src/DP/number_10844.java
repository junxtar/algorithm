package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_10844 {
	static long[][] dp;
	static int N;
	static long count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		final long mod = 1000000000;
		dp = new long[N + 1][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1] % mod;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][8] % mod;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		count(N);
		System.out.println(count%mod);

	}

	static void count(int N) {
		for (int j = 0; j < 10; j++) {
			count += dp[N][j];
		}

	}

}

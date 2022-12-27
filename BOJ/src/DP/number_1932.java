package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1932 {
	static int[][] arr;
	static int[][] dp;
	static int max = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j += 1;
			}
			
		}
		dp(n);
		System.out.println(sb);
	}

	static void dp(int n) {
		dp[0][0] = arr[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + arr[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1]+arr[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1])+arr[i][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (max < dp[n - 1][i])
				max = dp[n - 1][i];

		}
		sb.append(max);
	}

}

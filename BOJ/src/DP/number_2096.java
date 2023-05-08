package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2096 {
	
	static int N;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sb.append(search(true)).append(" ").append(search(false));
		System.out.print(sb.toString());

	}
	static int search(boolean isMax) {
		for (int i = 0; i < 3; i++) {
			dp[0][i] = map[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (isMax) {
					if (j == 0) {
						dp[i][j] = Math.max(map[i][j] + dp[i - 1][j], map[i][j] + dp[i - 1][j + 1]);
					} else if (j == 1) {
						dp[i][j] = Math.max(map[i][j] + dp[i - 1][j], map[i][j] + dp[i - 1][j + 1]);
						dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i - 1][j - 1]);
					} else {
						dp[i][j] = Math.max(map[i][j] + dp[i - 1][j], map[i][j] + dp[i - 1][j - 1]);
					}
				} else {
					if (j == 0) {
						dp[i][j] = Math.min(map[i][j] + dp[i - 1][j], map[i][j] + dp[i - 1][j + 1]);
					} else if (j == 1) {
						dp[i][j] = Math.min(map[i][j] + dp[i - 1][j], map[i][j] + dp[i - 1][j + 1]);
						dp[i][j] = Math.min(dp[i][j], map[i][j] + dp[i - 1][j - 1]);
					} else {
						dp[i][j] = Math.min(map[i][j] + dp[i - 1][j], map[i][j] + dp[i - 1][j - 1]);
					}
				}
			}
		}
		int value;
		if (isMax) {
			value = 0;
		} else {
			value = Integer.MAX_VALUE;
		}
		
		
		for (int i = 0; i < 3; i++) {
			if (isMax) {
				value = Math.max(value, dp[N - 1][i]);
			} else {
				value = Math.min(value, dp[N - 1][i]);
			}
		}
		return value;
	}

}

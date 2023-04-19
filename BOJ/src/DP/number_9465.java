package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_9465 {

	static int N;
	static int[][] dp;

	static StringBuilder sb = new StringBuilder();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			dp = new int[2][N + 1];
			int[][] map = new int[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			search(map);
		}
		System.out.println(sb.toString());

	}

	static void search(int[][] map) {
		for (int i = 0; i < N; i++) {
			dp[0][i + 1] = Math.max(dp[0][i], map[0][i] + dp[0 + 1][i]);
			dp[1][i + 1] = Math.max(dp[1][i], map[1][i] + dp[1 - 1][i]);
		}
		sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
	}
}

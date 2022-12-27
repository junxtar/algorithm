package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_25706 {
	static int N;
	static int[] dp, data;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		data = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		dp();
		System.out.println(sb);
	}

	static void dp() {
		dp[N] = 1;
		for (int i = N - 1; i > 0; i--) {
			if (i + 1 + data[i] > N) {
				dp[i] = 1;
			} else {
				dp[i] = dp[i + 1 + data[i]] + 1;
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(dp[i]).append(" ");
		}
	}
}

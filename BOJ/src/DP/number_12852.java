package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_12852 {
	static int[] dp;
	static int[] before;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		before = new int[N+1];
		dp = new int[N + 1];
		recur(N);
		save(N);
		System.out.println(sb);
	}

	public static void recur(int n) {
		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1]+1;
			before[i] = i - 1;
			if(i%3==0 && dp[i/3]+1<dp[i]) {
				dp[i] = dp[i/3]+1;
				before[i] = i/3;
			}
			if(i%2==0 && dp[i/2]+1 < dp[i]) {
				dp[i] = dp[i/2]+1;
				before[i] = i/2;
			}
		}
		sb.append(dp[n]+"\n");
	}
	public static void save(int n) {
		while(n>0) {
			sb.append(n+" ");
			n = before[n];
			
		}
	}
}

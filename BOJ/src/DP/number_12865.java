package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_12865 {
	static int N, K;
	static int[][] dp;
	static int[] W, V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N+1];
		V = new int[N+1];
		dp = new int[N+1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(knapasack());
	}
	static int knapasack() {
	
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=K; j++) {
				if(W[i] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]);
				}
			}
		}
		return dp[N][K];
		
	}

}

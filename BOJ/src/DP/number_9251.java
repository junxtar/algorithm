package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_9251 {
	
	static int[][] dp;
	static String str1, str2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		int N = str1.length();
		int M = str2.length();
		dp = new int[1001][1001];
		System.out.println(LCS(N,M));
		
	}
	
	static int LCS(int N, int M) {
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[N][M];
	}

}

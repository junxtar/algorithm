package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class number_9252 {

	static int length = 0;
	static int[][] dp;
	static int N, M;
	static String str1, str2;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		N = str1.length();
		M = str2.length();
		dp = new int[1001][1001];
		LCS(N, M);
		System.out.println(sb);
	}

	static void LCS(int N, int M) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		length = dp[N][M];
		sb.append(length).append("\n");
		
		Stack<Character> stack = new Stack<>();
		while(N > 0 && M > 0){
			if(N == 0 | M ==0)	break;
			
			if(dp[N][M] == dp[N-1][M]) {
				N--;
			}else if(dp[N][M] == dp[N][M-1]) {
				M--;
			}else {
				stack.push(str1.charAt(N-1));
				N--;
				M--;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}

}

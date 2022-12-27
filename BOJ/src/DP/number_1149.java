package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1149 {
	static int [][]arr;
	static int[][]dp;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dp = new int[n][3];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dp(n));
		
	}
	static int dp(int n) {
		for(int i = 0; i<3; i++) {
			dp[0][i] = arr[0][i];
		}
		for(int i = 1; i<n; i++) {
			for(int j=0; j<3; j++) {
				if(j==0)
					dp[i][j] = Math.min(arr[i][j]+dp[i-1][1],arr[i][j]+dp[i-1][2]);
				else if(j==1)
					dp[i][j] = Math.min(arr[i][j]+dp[i-1][0],arr[i][j]+dp[i-1][2]);
				else
					dp[i][j] = Math.min(arr[i][j]+dp[i-1][1],arr[i][j]+dp[i-1][0]);
				
			}
		}
		for(int i = 0; i<3; i++) {
			if(min > dp[n-1][i])
				min = dp[n-1][i];
		}
		return min;
	}

}

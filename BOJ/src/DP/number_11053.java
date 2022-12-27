package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_11053 {
	static int[]arr;
	static int[]dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dp(n));
	}	
	static int dp(int n) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++) {
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}

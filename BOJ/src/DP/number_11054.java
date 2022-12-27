package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_11054 {

	static int N;
	static int[] arr;
	static int[] dp;
	static int[] dpReverse;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1];
		dpReverse = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		search();
		arrSum(dp,dpReverse);
		System.out.println(max(dp));
	}

	static void search() {
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = 1;
			for(int j = 1; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		dpReverse[N] = 1;
		for (int i = N - 1; i >= 1; i--) {
			dpReverse[i] = 1;
			for(int j = N; i < j; j--) {
				if(arr[i] > arr[j] && dpReverse[i] < dpReverse[j]+1) {
					dpReverse[i] = dpReverse[j] + 1;
				}
			} 
		}
	}
	
	static void arrSum(int[]dp, int[]dpReverse) {
		for(int i = 1; i<=N; i++) {
			dp[i] = dp[i] + dpReverse[i] - 1;
		}
	}
	
	static int max(int[]dp) {
		int max = Integer.MIN_VALUE;
		for(int i = 1; i<=N; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}
}

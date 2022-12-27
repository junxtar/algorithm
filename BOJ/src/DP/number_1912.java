package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_1912 {
	static int[] arr;
	static int[] dp;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dp(n));
		
	}

	public static int dp(int n) {
		dp[0] = arr[0];
		if (n >= 1) {
			for (int i = 1; i < n; i++) {
				dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
			}
			max = Arrays.stream(dp).max().getAsInt();
		}
		return max;
	}
	

}

package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_11055 {
	static int[]arr;
	static int[]dp;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr= new int[n+1];
		dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		recur(n);
		System.out.println(result);;
	}
	
	static void recur(int n){
		dp[1] = arr[1];
		for(int i = 2; i<=n; i++) {
			int temp = Integer.MIN_VALUE;
			int index = 0;
			for(int j = 1; j<i; j++) {
				if(arr[i] <= arr[j])
					continue;
				else {
					if(temp < dp[j]) {
						temp = dp[j];
						index = j;
					}
				}
			}
			dp[i] = dp[index]+arr[i];
			result = Math.max(dp[i], result);
		}
		result = Math.max(result, dp[1]);

	}

}

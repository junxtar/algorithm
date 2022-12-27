package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_11722 {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(recur(arr,dp));
		for(int data:dp) {
			System.out.print(data+" ");
		}
	}
	
	static int recur(int[]arr, int[]dp) {
		int max = 1;
		dp[N] = 1;
		for(int i = N-1; i > 0; i--) {
			dp[i] = 1;
			for(int j = N; j > i; j--) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
					if(dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}
		return max;
	}

}

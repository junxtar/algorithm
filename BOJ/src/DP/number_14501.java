package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_14501 {
	static int[]day, cost, dp;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		day = new int[N+1];
		cost = new int[N+1];
		dp = new int[N+2];
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dp());
		
	}
	static int dp() {	
		for(int i = N; i>0; i--) {
			if(i + day[i] > N+1)
				dp[i] = dp[i+1];
			else
				dp[i] = Math.max(dp[i+1], cost[i]+dp[i+day[i]]);
			
		}
		
		return dp[1];
	}
	
	

}

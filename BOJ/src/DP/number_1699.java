package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_1699 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []dp = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			dp[i] = i; 
			//1 2 3 4 5 6
			for(int j = 1; j*j<=i; j++) {
				//1 1 1 2 2 2 2 2
				//1 2 3 1 2 3 4 2  
				if(dp[i] > dp[i - j * j] + 1) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}
		
		
		System.out.println(dp[N]);
	}
}

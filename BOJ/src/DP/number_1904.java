package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_1904 {
	static int[]arr = new int[1000001];
	static int dp(int n) {
	
		arr[1] = 1;
		arr[2] = 2;
		for(int i = 3; i<=n; i++) {
			arr[i] = (arr[i-2]+arr[i-1]) % 15746;
		}
		return arr[n];
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(dp(n));
	}

}

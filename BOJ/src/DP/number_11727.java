package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_11727 {
	static int[] arr;

	static int dp(int n) {
		arr[1] = 1;
		if (n > 1) {
			arr[2] = 3;
			for(int i = 3; i<=n; i++) {
				arr[i] = ((arr[i-2]*2) + arr[i-1])%10007;
			}
		}
		return arr[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		System.out.println(dp(n));
	}

}

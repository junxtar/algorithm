package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_24416 {

	static int[]arr = new int[41];
	
	static int fibonacci(int n) {
		arr[1] = 1; arr[2] = 1;
		for(int i = 3; i<=n; i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		return arr[n];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		br.close();
		sb.append(fibonacci(n)).append(" ").append(n-2);
		
		System.out.println(sb);
	}

}

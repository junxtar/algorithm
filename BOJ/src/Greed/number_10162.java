package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_10162 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = { 300, 60, 10 };

		for (int i = 0; i < arr.length; i++) {
			sb.append(n / arr[i]).append(" ");
			n %= arr[i];
		}
		if (n != 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
	}

}

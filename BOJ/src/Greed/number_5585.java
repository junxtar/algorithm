package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_5585 {
	
	static int money;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		money = 1000 - n;
		System.out.print(calculation());
	}
	
	static int calculation() {
		int[]arr = {500, 100, 50, 10, 5, 1};
		for(int i = 0; i<arr.length; i++) {
			count+=(money / arr[i]);
			money %= arr[i];
		}
		return count;
	}
	
}

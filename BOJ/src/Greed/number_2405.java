package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class number_2405 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[]data = new int[N];
		
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(data);
		
		System.out.println(Search(data));

	}
	
	public static int Search(int[]arr) {
		int max = Integer.MIN_VALUE;
		for(int i = 1; i<N-1; i++) {
			int first = arr[0];
			int mid = arr[i];
			int last = arr[i+1];
			max = Math.max(max, Math.abs(first + last -2*mid));
		}
		
		for(int i = 0; i<N-2; i++) {
			int first = arr[i];
			int mid = arr[i+1];
			int last = arr[N-1];
			max = Math.max(max, Math.abs(first + last - 2*mid));
		}
		return max;
	}

}

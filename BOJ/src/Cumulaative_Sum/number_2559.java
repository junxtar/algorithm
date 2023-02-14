package Cumulaative_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N - K + 1];
		int[] temp = new int[N];
		int max = -9999;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < temp.length; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			
		}
		for(int i = 0; i< arr.length; i++) {
			int sum = 0;
			for(int j = i; j<i+K; j++) {
				sum += temp[j];
				
			}
			max = Math.max(max, sum);
			
			
		}
		System.out.println(max);
	}

}

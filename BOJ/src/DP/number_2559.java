package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2559 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int index = K;
		for(int i = 0; i<K; i++) {
			sum+=arr[i];
		}
		max = sum;
		while(index<N) {
			sum+=arr[index];
			sum-=arr[index - K];
			if(sum >= max) {
				max = sum;
			}
			index++;
		}
		System.out.println(max);
	}
}

package Cumulaative_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int sum = 0;
		int start = 0;
		int end = 0;
		int result = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		if(sum < S) {
			result = 0;
		}else {
			sum = 0;
			while(start <= N && end <= N) {
				if(sum >= S) {
					sum-=arr[start];
					result = Math.min(result, end - start);
					start++;
				}else if(end == N){
					break;
				}else {
					sum+=arr[end++];
				}
			}
		}
		System.out.println(result);
		
	}
}
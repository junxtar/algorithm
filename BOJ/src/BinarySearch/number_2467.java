package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = N - 1;
		
		int min = 0;
		int max = 0;
		
		int gap = Integer.MAX_VALUE;
		
		int sum = 0;
		int absSum = 0;
				
		while (start < end) {
			sum = arr[start] + arr[end];
			absSum = Math.abs(sum);
			if (gap > absSum) {
				min = arr[start];
				max = arr[end];
				gap = absSum;
			}
			
			if (sum > 0) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(min+" "+max);
	}

}

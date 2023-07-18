package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_2473 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);

		long first = 0;
		long two = 0;
		long three = 0;

		long gap = Long.MAX_VALUE;

		for (int i = 0; i < N - 2; i++) {
			int ro = i + 1;
			int hi = N - 1;
			while (ro < hi) {
				long sum = arr[ro] + arr[i] + arr[hi];
				long absSum = Math.abs(sum);
				if (absSum < gap) {
					first = arr[i];
					two = arr[ro];
					three = arr[hi];
					gap = absSum;
				}
				if (sum > 0) {
					hi--;
				} else {
					ro++;
				}
			}
		}
		System.out.println(first + " " + two + " " + three);
	}
}

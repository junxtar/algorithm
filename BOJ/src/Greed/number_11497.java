package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_11497 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] values = new int[N + 1];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			values = collocate(N, arr);
			int result = Integer.MIN_VALUE;
			for (int i = 0; i < values.length - 1; i++) {
				int value = Math.abs(values[i + 1] - values[i]);
				result = Math.max(result, value);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int[] collocate(int N, int[] arr) {
		int[] values = new int[N + 1];
		int start = 0;
		int end = arr.length - 1;
		int index = 0;
		for (int i = 0; i < N; i++) {
			values[index] = arr[i];
			if (index == start) {
				index = end;
				start++;
			} else {
				index = start;
				end--;
			}
		}
		values[N] = arr[0];
		return values;
	}
}

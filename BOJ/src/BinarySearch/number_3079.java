package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_3079 {

	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		init();
		solution();
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

	}

	private static void solution() {
		long left = 0;
		long right = (long) arr[n - 1] * m;
		long answer = right;
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			for (int time : arr) {
				cnt += mid / time;
				if (cnt >= m) {
					break;
				}
			}
			if (cnt >= m) {
				answer = Math.min(answer, right);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_2018 {

	static int n;
	static int answer = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		init();
		solution();
		System.out.println(answer);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
	}

	private static void solution() {
		int value = 0;
		int left = 0;
		int right = 0;
		while (true) {
			if (value == n) {
				answer++;
			}
			if (value >= n) {
				value -= arr[left++];
			} else if (right == n) {
				break;
			} else {
				value += arr[right++];
			}
		}
	}
}
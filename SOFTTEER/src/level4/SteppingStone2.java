package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SteppingStone2 {

	static int N;
	static int[] dp;
	static int[] reverseDp;
	static int[] arr;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1];
		reverseDp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		search();
		sum(dp, reverseDp);
		System.out.println(answer(dp));

	}

	static void search() {
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {

		}
		reverseDp[N] = 1;
		for (int i = N - 1; i > 0; i--) {
			reverseDp[i] = 1;
			for (int j = N; j > i; j--) {
				if (arr[i] > arr[j] && reverseDp[i] < reverseDp[j] + 1) {
					reverseDp[i] = reverseDp[j] + 1;
				}
			}
		}
	}

	static void sum(int[] dp, int[] reverseDp) {
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i] + reverseDp[i] - 1;
		}
	}

	static int answer(int[] dp) {
		int result = 0;
		for (int i = 1; i < dp.length; i++) {
			result = Math.max(result, dp[i]);
		}
		return result;
	}

}
package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_14888 {
	static int N;
	static int[] arr;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		backtrackking(0, arr[0]);
		System.out.println(max);
		System.out.println(min);

	}

	static void backtrackking(int depth, int num) {
		if (depth == N - 1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for (int i = 0; i < op.length; i++) {
			if (op[i] > 0) {
				op[i]--;
				switch (i) {
				case 0:
					backtrackking(depth + 1, num + arr[depth + 1]);
					break;
				case 1:
					backtrackking(depth + 1, num - arr[depth + 1]);
					break;
				case 2:
					backtrackking(depth + 1, num * arr[depth + 1]);
					break;
				case 3:
					backtrackking(depth + 1, num / arr[depth + 1]);
					break;
				}
				op[i]++;
			}
		}
	}
}

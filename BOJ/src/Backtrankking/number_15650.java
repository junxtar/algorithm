package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_15650 {
	public static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int temp = 0;
	static int N, M;
	static int depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(1,0);
		System.out.println(sb);

	}

	public static void dfs(int at, int depth) {
		if (depth == M) {
			for (int data : arr) {
				sb.append(data + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);

		}

	}

}

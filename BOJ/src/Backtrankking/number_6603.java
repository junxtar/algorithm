package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_6603 {

	static StringBuilder sb = new StringBuilder();
	static int[] element;
	static int[] arr;
	static int N;
	static int M = 6;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		while (!temp.equals("0")) {
			StringTokenizer st = new StringTokenizer(temp);
			N = Integer.parseInt(st.nextToken());
			arr = new int[M];
			element = new int[N];
	
			for (int i = 0; i < N; i++) {
				element[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("\n");
			temp = br.readLine();
		}
		System.out.println(sb);
	}

	static void dfs(int at, int depth) {
		if (M == depth) {
			for (int data : arr) {
				sb.append(data + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = at; i < N; i++) {
			arr[depth] = element[i];
			dfs(i + 1, depth + 1);

		}
	}

}

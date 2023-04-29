package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class number_15663 {

	static int N, M;
	static int[] value;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		value = new int[N];
		arr = new int[M];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(value);
		dfs(0);
		for (String s : set) {
			sb.append(s).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int depth) {
		String str = "";
		if (M == depth) {
			for (int data : arr) {
				str += data+" ";
			}
			set.add(str);
			return;
		}

		for (int i = 0; i < value.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = value[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}

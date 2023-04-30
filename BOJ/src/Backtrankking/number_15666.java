package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class number_15666 {

	static int N, M;
	static int[] value;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		value = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(value);
		dfs(0, 0);
		
		
		System.out.println(sb.toString());
	}

	static void dfs(int start, int depth) {
		if (M == depth) {
			for (int i = 0; i <= arr.length - 1; i++) {
				sb.append(arr[i]+" ");
			}sb.append("\n");
			return;
		}
		int num = 0;
		for (int i = start; i < value.length; i++) {
			if (num == value[i]) continue;
			arr[depth] = value[i];
			dfs(i, depth + 1);
			num = value[i];
		}
	}
}

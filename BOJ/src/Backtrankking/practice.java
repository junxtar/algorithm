package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int N, M;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];
		dfs(N,M,0);
		System.out.println(sb);
	}
	
	static void dfs(int n, int m, int depth) {
		if (m == depth) {
			for (int data : arr) {
				sb.append(data + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(n,m,depth+1);
				visit[i] = false;
			}
		}
	}

}

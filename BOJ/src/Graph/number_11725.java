package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class number_11725 {

	static int N;
	static int[] parents;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		dfs(1);
		for(int i = 2; i<=N; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int root) {
		for(int data:list.get(root)) {
			if(!visited[data]) {
				visited[data] = true;
				parents[data] = root;
				dfs(data);
			}
		}
	}
}

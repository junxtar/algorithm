package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_14567 {

	static int N, M;
	static int[] dp;
	static int[] seq;
	static ArrayList<ArrayList<Integer>> grapgh;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dp = new int[N + 1];
		seq = new int[N + 1];
		grapgh = new ArrayList<>();

		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			seq[v]++;
			grapgh.get(u).add(v);
		}
		topologicalSort();
		
		for (int i = 1; i < dp.length; i++) {
			sb.append(dp[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < seq.length; i++) {
			if (seq[i] == 0) {
				q.offer(i);
				dp[i] = 1;
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : grapgh.get(cur)) {
				dp[next] = Math.max(dp[next], dp[cur] + 1);
				
				if(--seq[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}

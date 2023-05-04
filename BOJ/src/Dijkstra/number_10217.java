package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_10217 {

	static class Node {
		int v, w, c;

		public Node(int v, int w, int c) {
			this.v = v;
			this.w = w;
			this.c = c;
		}
	}

	static int N, M, K;
	static int[][] dp;
	static boolean[] visited;
	static final int INF = 100001;
	static ArrayList<ArrayList<Node>> grapgh;
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			visited = new boolean[N + 1];
			grapgh = new ArrayList<>();
			dp = new int[N + 1][M + 1];
			for (int i = 0; i <= N; i++) {
				grapgh.add(new ArrayList<>());
				Arrays.fill(dp[i], INF);

			}
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				grapgh.get(u).add(new Node(v, d, c));
			}
			dijkstra();

			int min = INF;

			for (int value : dp[N]) {
				System.out.println(value+ " ");
				min = Math.min(value, min);
			}
			if (min == INF) {
				sb.append("Poor KCM").append("\n");
			} else {
				sb.append(min).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void dijkstra() {
		pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		dp[1][0] = 0;
		pq.offer(new int[] { 1, 0 });

		while (!pq.isEmpty()) {
			int n = pq.poll()[0];

			if (visited[n])
				continue;
			visited[n] = true;

			for (Node next : grapgh.get(n)) {
				int min = INF;
				for (int i = 0; i <= M - next.c; i++) {
					if (dp[n][i] == INF)
						continue;
					dp[next.v][i + next.c] = Math.min(dp[n][i] + next.w, dp[next.v][i + next.c]);
					min = Math.min(min, dp[next.v][i + next.c]);
				}
				pq.offer(new int[] { next.v, min });
			}

		}
	}
}
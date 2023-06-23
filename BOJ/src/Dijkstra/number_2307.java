package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_2307 {

	static class Node {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int N, M;
	static final int INF = 50000001;
	static ArrayList<ArrayList<Node>> grapgh;
	static int[] dist;
	static int[] road;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		road = new int[N + 1];

		grapgh = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
		}
		int shortRoad = dijkstra(0, 0, true);
		int ans = 0;
		for (int i = 2; i <= N; i++) {
			int distance = dijkstra(road[i], i, false);

			ans = Math.max(ans, distance - shortRoad);
			if (distance == INF) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(ans);
	}

	static int dijkstra(int start, int end, boolean isFirst) {
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		dist[1] = 0;
		pq.offer(new Node(1, dist[1]));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.v] < cur.w)
				continue;
			if (visited[cur.v])
				continue;

			visited[cur.v] = true;

			for (Node next : grapgh.get(cur.v)) {
				if (cur.v == start && next.v == end)
					continue;

				if (dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					road[next.v] = isFirst ? cur.v : road[next.v];
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		return dist[N];
	}
}

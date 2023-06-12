package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_9370 {

	static class Node {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int n, m, t;
	static int s, g, h;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> grapgh;
	static ArrayList<Integer> nodes;
	static final int INF = 50000000;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			dist = new int[n + 1];
			visited = new boolean[n + 1];
			grapgh = new ArrayList<>();
			nodes = new ArrayList<>();
			Arrays.fill(dist, INF);

			for (int i = 0; i < n + 1; i++) {
				grapgh.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				if ((g == u && h == v) || (g == v && h == u)) {
					grapgh.get(u).add(new Node(v, w * 2 - 1));
					grapgh.get(v).add(new Node(u, w * 2 - 1));
					continue;
				}
				grapgh.get(u).add(new Node(v, w * 2));
				grapgh.get(v).add(new Node(u, w * 2));
			}
			dijkstra(s);
			while (t-- > 0) {
				int node = Integer.parseInt(br.readLine());
				nodes.add(node);
			}
			Collections.sort(nodes);

			for (int node : nodes) {
				if (dist[node] % 2 == 1) {
					sb.append(node).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.v] || dist[cur.v] < cur.w) {
				continue;
			}
			visited[cur.v] = true;
			for (Node next : grapgh.get(cur.v)) {
				if (!visited[next.v] && dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
}

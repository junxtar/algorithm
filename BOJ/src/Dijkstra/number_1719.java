package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1719 {

	static class Node {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int N, M;
	static int[] dist;
	static int[] route;
	static ArrayList<ArrayList<Node>> grapgh = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
		}
		for (int i = 1; i <= N; i++) {
			dist = new int[N + 1];
			route = new int[N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(i);
		}
		System.out.println(sb.toString());
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.v] < cur.w)
				continue;

			for (Node next : grapgh.get(cur.v)) {
				if (dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					if (cur.v == start) {
						route[next.v] = next.v;
					} else {
						route[next.v] = route[cur.v];
					}
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (start == i) {
				sb.append("-").append(" ");
				continue;
			}
			sb.append(route[i]).append(" ");
		}
		sb.append("\n");
	}
}

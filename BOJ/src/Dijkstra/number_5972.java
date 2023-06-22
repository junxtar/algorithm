package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_5972 {
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
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> grapgh;
	static final int INF = 50000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(dist, INF);
		grapgh = new ArrayList<>();
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
		System.out.println(dijkstra(1));
	}
	static int dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.v]) continue;
			if (dist[cur.v] < cur.w) continue;
			
			visited[cur.v] = true;
			
			for(Node next : grapgh.get(cur.v)) {
				if (!visited[next.v] && dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		return dist[N];
	}
}

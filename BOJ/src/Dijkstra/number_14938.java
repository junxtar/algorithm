package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_14938 {

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
	static int[] item;
	static ArrayList<ArrayList<Node>> grapgh;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		item = new int[N + 1];

		grapgh = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < item.length; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		while (r-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
		}
		int result = 0;
		for (int i = 1; i < N + 1; i++) {
			result = Math.max(result, dijkstra(i));
		}
		System.out.println(result);
	}

	static int dijkstra(int start) {
		dist = new int[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		dist[start] = item[start];
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.w >= M)
				continue;

			for (Node next : grapgh.get(cur.v)) {
				if (dist[next.v] < dist[cur.v] + item[next.v]) {
					if (cur.w + next.w <= M) {
						dist[next.v] = dist[cur.v] + item[next.v];
						pq.offer(new Node(next.v, cur.w + next.w));
					}
				}
			}
		}
		int result = 0;
		for (int i = 1; i < item.length; i++) {
			if(dist[i] != 0) {
				result += item[i];
			}
		}
		return result;
	}
}

package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Delivery {

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	private int[] dist;
	private List<List<Node>> grapgh = new ArrayList<>();

	public int solution(int N, int[][] road, int K) {
		init(N, road);
		dijkstra(1);
		return getArrive(K);
	}

	private void init(int N, int[][] road) {
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++) {
			grapgh.add(new ArrayList<>());
		}

		for (int i = 0; i < road.length; i++) {
			int u = road[i][0];
			int v = road[i][1];
			int w = road[i][2];

			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
		}
	}

	private void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.v] < cur.w) {
				continue;
			}

			for (Node next : grapgh.get(cur.v)) {
				if (dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

	private int getArrive(int K) {
		int cnt = 0;
		for (int i = 1; i < dist.length; i++) {
			if (K >= dist[i]) {
				cnt++;
			}
		}
		return cnt;
	}
}

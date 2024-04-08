package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TaxiFare {

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	List<List<Node>> grapgh = new ArrayList<>();

	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		init(n, fares);
		int[] together = dijkstra(s, n);
		int[] aStart = dijkstra(a, n);
		int[] bStart = dijkstra(b, n);
		for (int i = 1; i <= n; i++) {
			int result = together[i] + aStart[i] + bStart[i];
			answer = Math.min(answer, result);
		}

		return answer;
	}

	private void init(int n, int[][] fares) {
		for (int i = 0; i <= n; i++) {
			grapgh.add(new ArrayList<>());
		}
		for (int i = 0; i < fares.length; i++) {
			int u = fares[i][0];
			int v = fares[i][1];
			int w = fares[i][2];

			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
		}
	}

	private int[] dijkstra(int start, int n) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(start, 0));
		dist[start] = 0;
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
		return dist;
	}
}

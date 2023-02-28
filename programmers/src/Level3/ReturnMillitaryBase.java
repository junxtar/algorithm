package Level3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReturnMillitaryBase {

	static class Node {
		int u;
		int v;

		public Node(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}

	static int[] dist;
	static ArrayList<ArrayList<Node>> grapgh = new ArrayList<>();

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i <= n; i++) {
			grapgh.add(new ArrayList<>());
		}

		for (int i = 0; i < roads.length; i++) {
			grapgh.get(roads[i][0]).add(new Node(roads[i][1], 1));
			grapgh.get(roads[i][1]).add(new Node(roads[i][0], 1));
		}

		bfs(destination);

		for (int i = 0; i < sources.length; i++) {
			if (dist[sources[i]] == Integer.MAX_VALUE) {
				answer[i] = -1;
				continue;
			}
			answer[i] = dist[sources[i]];
		}
		return answer;
	}

	// destination에서 출발해서 sources 값을 찾는 방식으로 구현
	static void bfs(int start) {

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.u - o2.u);

		dist[start] = 0;

		pq.offer(new Node(start, dist[start]));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			for (Node next : grapgh.get(now.u)) {
				if (dist[next.u] > now.v + next.v) {
					dist[next.u] = now.v + next.v;
					pq.offer(new Node(next.u, dist[next.u]));
				}
			}
		}
	}
}
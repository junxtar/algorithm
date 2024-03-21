package Level3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingIslands {
	
	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	private boolean[] visited;
	private int cnt = 0;
	private int answer = 0;
	private ArrayList<ArrayList<Node>> list = new ArrayList<>();

	public int solution(int n, int[][] costs) {
		init(n, costs);
		spt(n);
		return answer;
	}

	private void init(int n, int[][] costs) {
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[n];

		for (int i = 0; i < costs.length; i++) {
			int u = costs[i][0];
			int v = costs[i][1];
			int w = costs[i][2];
			list.get(u).add(new Node(v, w));
			list.get(v).add(new Node(u, w));
		}
	}

	private void spt(int n) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(0, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.v]) {
				continue;
			}
			visited[now.v] = true;
			answer += now.w;

			for (Node next : list.get(now.v)) {
				if (!visited[next.v]) {
					pq.offer(next);
				}
			}
			if (cnt++ == n)
				break;
		}
	}
}
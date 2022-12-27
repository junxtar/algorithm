package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_13549 {

	static class Node {
		int value;
		int second;

		Node(int value, int second) {
			this.value = value;
			this.second = second;
		}
	}

	static int N, K, min, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(bfs(N, 0));
	}

	static int bfs(int value, int second) {
		PriorityQueue<Node>pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.second - o2.second;
			}
			
		});
		boolean[] visited = new boolean[100001];
		pq.offer(new Node(value, second));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			visited[cur.value] = true;
			
			if (cur.value == K) {
				return cur.second;
			}
			int dx = cur.value - 1;
			int nx = cur.value + 1;
			int jx = cur.value * 2;

			if (dx >= 0 && !visited[dx]) {
				pq.offer(new Node(dx, cur.second + 1));
			}
			if (nx <= 100000 && !visited[nx]) {
				pq.offer(new Node(nx, cur.second + 1));
			}
			if (jx <= 100000 && !visited[jx]) {
				pq.offer(new Node(jx, cur.second));
			}
		}
		return 0;
	}
}
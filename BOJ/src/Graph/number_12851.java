package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_12851 {

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
		min = Integer.MAX_VALUE;
		count = 1;
		if (N > K) {
			System.out.println(N - K);
			System.out.println(1);
		} else {
			bfs(N, 0);
			System.out.println(min);
			System.out.println(count);
		}
	}

	static void bfs(int value, int second) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		q.offer(new Node(value, second));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			visited[cur.value] = true;
			if (cur.value == K) {
				if (min > cur.second) {
					min = cur.second;
				} else if (min == cur.second) {
					count++;
				}
				continue;
			}
			int dx = cur.value - 1;
			int nx = cur.value + 1;
			int jx = cur.value * 2;

			if (dx >= 0 && !visited[dx]) {
				q.offer(new Node(dx, cur.second + 1));
			}
			if (nx <= 100000 && !visited[nx]) {
				q.offer(new Node(nx, cur.second + 1));
			}
			if (jx <= 100000 && !visited[jx]) {
				q.offer(new Node(jx, cur.second + 1));
			}
		}
	}
}

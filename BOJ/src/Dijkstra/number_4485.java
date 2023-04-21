package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_4485 {

	static class Node {
		int x;
		int y;
		int value;

		Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	static int N = -1;
	static int[][] cost;
	static int[][] map;
	static int[] dxy = { 1, 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 0;
		StringTokenizer st;
		while (true) {
			count++;
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			cost = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			}
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(count + ": ").append(dijkstra(0, 0)).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
		cost[start][end] = map[start][end];
		pq.offer(new Node(start, end, cost[start][end]));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 | nx >= N | ny < 0 | ny >= N)
					continue;

				if (cost[nx][ny] > map[nx][ny] + cur.value) {
					cost[nx][ny] = map[nx][ny] + cur.value;
					pq.offer(new Node(nx, ny, cost[nx][ny]));
				}
			}
		}
		return cost[N - 1][N - 1];
	}

}

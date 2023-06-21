package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1261 {

	static class Node {
		int x;
		int y;
		int count;

		Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	static int N, M;
	static int[][] map;
	static int[][] cost;
	static int[] dxy = { 1, 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cost = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0, 0));
	}

	static int bfs(int row, int col) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
		pq.offer(new Node(row, col, 0));

		cost[row][col] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];
				if (nx < 0 | nx >= N | ny < 0 | ny >= M) continue;
				
				if (cost[nx][ny] > cost[cur.x][cur.y] + map[nx][ny]) {
					cost[nx][ny] = cost[cur.x][cur.y] + map[nx][ny];
					pq.offer(new Node(nx, ny, cost[nx][ny]));
				}
			}
		}
		return cost[N - 1][M - 1];
	}

}

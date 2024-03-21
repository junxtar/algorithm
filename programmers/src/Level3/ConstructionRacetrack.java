package Level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConstructionRacetrack {

	static class Node {
		int x;
		int y;
		int w;
		int dir;

		public Node(int x, int y, int w, int dir) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.dir = dir;
		}
	}

	private int size;
	private int[] dxy = { 1, 0, -1, 0, 1 };
	private int[][][] dist;

	public int solution(int[][] board) {
		size = board.length;
		dist = new int[size][size][2];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
			}
		}
		return dijkstra(0, 0, board);
	}

	private int dijkstra(int x, int y, int[][] board) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(x, y, 0, 0));
		pq.offer(new Node(x, y, 0, 1));
		dist[x][y][0] = 0;
		dist[x][y][1] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 || ny < 0 || nx >= size || ny >= size || board[nx][ny] == 1) {
					continue;
				}
				int dir = i % 2;
				int turn = dir == cur.dir ? 100 : 600;

				if (dist[nx][ny][dir] > cur.w + turn) {
					dist[nx][ny][dir] = cur.w + turn;
					pq.offer(new Node(nx, ny, dist[nx][ny][dir], dir));
				}
			}
		}
		return Math.min(dist[size - 1][size - 1][0], dist[size - 1][size - 1][1]);
	}
}

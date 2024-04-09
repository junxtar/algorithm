package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class VerifyingDistancing {

	static class Node {
		int x;
		int y;
		int z;

		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	private final int N = 5;
	private boolean[][] visited;
	private int[] dxy = { 1, 0, -1, 0, 1 };

	public int[] solution(String[][] places) {
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			String[] map = places[i];
			boolean temp = true;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j].charAt(k) == 'P') {
						if (!bfs(map, j, k)) {
							temp = false;
							break;
						}
					}
				}
				if (!temp) {
					break;
				}
			}
			answer[i] = temp ? 1 : 0;
		}
		return answer;
	}

	private boolean bfs(String[] map, int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0));
		visited = new boolean[N][N];
		visited[row][col] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.z == 2) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (indexOut(nx, ny)) {
					continue;
				}
				if (!visited[nx][ny] && map[nx].charAt(ny) == 'P') {
					return false;
				}
				if (!visited[nx][ny] && map[nx].charAt(ny) == 'O') {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, cur.z + 1));
				}
			}
		}
		return true;
	}

	private boolean indexOut(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return true;
		}
		return false;
	}
}

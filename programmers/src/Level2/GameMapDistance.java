package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapDistance {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public int solution(int[][] maps) {
		int size = maps.length;
		bfs(0, 0, maps);
		if (maps[maps.length - 1][maps[0].length - 1] == 1)
			return -1;
		return maps[maps.length - 1][maps[0].length - 1];
	}

	static void bfs(int row, int col, int[][] maps) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | nx >= maps.length | ny < 0 | ny >= maps[0].length)
					continue;
				if (maps[nx][ny] == 1) {
					maps[nx][ny] = maps[cur.x][cur.y] + 1;
					q.offer(new Node(nx, ny));
				}
			}
		}
	}
}
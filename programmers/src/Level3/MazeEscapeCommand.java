package Level3;

import java.util.PriorityQueue;

public class MazeEscapeCommand {

	static class Node {
		int x;
		int y;
		String text;

		Node(int x, int y, String text) {
			this.x = x;
			this.y = y;
			this.text = text;
		}
	}

	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, -1, 1, 0 };
	static char[] ch = { 'd', 'l', 'r', 'u' };
	static char[][] map;

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		init(n, m, x, y, r, c);
		if (isImpossible(0, x, y, r, c, k)) {
			return "impossible";
		}
		return bfs(x - 1, y - 1, r - 1, c - 1, k);
	}

	private static void init(int n, int m, int x, int y, int r, int c) {
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == x - 1 && j == y - 1) {
					map[i][j] = 'S';
					continue;
				}
				if (i == r - 1 && j == c - 1) {
					map[i][j] = 'E';
					continue;
				}
				map[i][j] = '.';
			}
		}
	}

	private String bfs(int x, int y, int r, int c, int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.text.length() - o1.text.length());
		pq.offer(new Node(x, y, ""));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.x == r && cur.y == c && cur.text.length() == k) {
				return cur.text;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				String nt = cur.text + ch[i];
				if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length
						|| isImpossible(nt.length(), nx, ny, r, c, k)) {
					continue;
				}

				pq.offer(new Node(nx, ny, nt));
			}
		}
		return "impossible";
	}

	private boolean isImpossible(int size, int nx, int ny, int r, int c, int k) {
		int dir = (Math.abs(r - nx) + Math.abs(c - ny));
		if ((k - size) < dir || ((k - size) - dir) % 2 == 1) {
			return true;
		}
		return false;
	}
}
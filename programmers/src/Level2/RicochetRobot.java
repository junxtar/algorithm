package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobot {

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

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;

	public int solution(String[] board) {
		int sx = 0;
		int sy = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if (board[i].charAt(j) == 'R') {
					sx = i;
					sy = j;
				}
			}
		}
		return bfs(board, sx, sy);
	}

	static int bfs(String[] board, int row, int col) {
		
		visited = new boolean[board.length][board[0].length()];
		visited[row][col] = true;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0));
		
		int N = board.length;
		int M = board[0].length();
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (board[cur.x].charAt(cur.y) == 'G')
				return cur.z;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				while (board[nx].charAt(ny) != 'D') {
					nx += dx[i];
					ny += dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						break;
				}
				if (!visited[nx - dx[i]][ny - dy[i]]) {
					q.offer(new Node(nx - dx[i], ny - dy[i], cur.z + 1));
					visited[nx - dx[i]][ny - dy[i]] = true;
				}
			}
		}
		return -1;
	}
}
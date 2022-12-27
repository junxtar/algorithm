package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_7562 {

	static class Node {
		int x;
		int y;
		int z;
		Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int N, min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, -1, -2, -2, 1, 1, 2, 2 };
	static int[] dy = { 2, -2, 1, -1, 2, -2, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int targetRow = Integer.parseInt(st.nextToken());
			int targetColumn = Integer.parseInt(st.nextToken());
			bfs(row, column,targetRow, targetColumn);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int row, int column, int targetRow, int targetColumn) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, column, 0));
		visited[row][column] = true;
		min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			int cd = cur.z;
			if(cx == targetRow && cy == targetColumn) {
				min = Math.min(min, cd);
			}
			for (int j = 0; j < 8; j++) {
				int nx = cur.x + dx[j];
				int ny = cur.y + dy[j];
				if (nx < 0 | nx >= N | ny < 0 | ny >= N)
					continue;
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, cd+1));
				}
			}
		}
	}
}

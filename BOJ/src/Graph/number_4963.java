package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_4963 {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int w;
	static int h;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str;
		
		while (!(str = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			int count = 0;
			map = new int[w][h];
			visited = new boolean[w][h];
			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < h; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int row, int column) {
		Queue<Node> q = new LinkedList<>();
		visited[row][column] = true;
		q.offer(new Node(row, column));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | nx >= w | ny < 0 | ny >= h)
					continue;
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					q.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}

	}

}

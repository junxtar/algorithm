package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2206 {

	static class Node {

		int x;
		int y;
		int z;
		boolean destroyed;

		public Node(int x, int y, int z, boolean d) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.destroyed = d;
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0,0);
	}

	static void bfs(int row, int column) {
		visited = new boolean[2][N][M];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, column, 1, false));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.x == N -1 && cur.y == M-1) {
				System.out.println(cur.z);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | nx >= N | ny < 0 | ny >= M)
					continue;
				if (map[nx][ny] == 0) {
					if (!cur.destroyed && !visited[0][nx][ny]) {
						q.offer(new Node(nx, ny, cur.z + 1, false));
						visited[0][nx][ny] = true;
					} else if (cur.destroyed && !visited[1][nx][ny]) {
						q.offer(new Node(nx, ny, cur.z + 1, true));
						visited[1][nx][ny] = true;
					}
				} else if (map[nx][ny] == 1) {
					if (!cur.destroyed) {
						q.offer(new Node(nx, ny, cur.z + 1, true));
						visited[1][nx][ny] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}

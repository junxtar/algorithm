package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_1600 {

	static class Node {
		int x;
		int y;
		int z;
		int k;
		Node(int x, int y, int z, int k) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.k = k;
		}
	}

	static int K, N, M;
	static int result = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dxy = { 1, 0, -1, 0, 1 };
	static int[] jx = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] jy = { -1, 1, -2, 2, 2, -2, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);

	}

	static void bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0, 0));
		visited[row][col][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				result = Math.min(result, cur.z);
			}

			if (cur.k < K) {
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + jx[i];
					int ny = cur.y + jy[i];

					if (nx < 0 | ny < 0 | nx >= N | ny >= M)
						continue;

					if (map[nx][ny] == 0 && !visited[nx][ny][cur.k + 1]) {
						visited[nx][ny][cur.k + 1] = true;
						q.offer(new Node(nx, ny, cur.z + 1, cur.k + 1));
					}
				}
				
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 | ny < 0 | nx >= N | ny >= M )
					continue;
				
				if (map[nx][ny] == 0 && !visited[nx][ny][cur.k]) {
					visited[nx][ny][cur.k] = true;
					q.offer(new Node(nx, ny, cur.z + 1, cur.k));
				}
			}
		}
	}
}

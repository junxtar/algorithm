package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_14502 {
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int M;
	static int safeCount = -3;
	static int minCount = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					safeCount++;
				}
			}
		}
		updateMap(0);
		System.out.println(safeCount - minCount);

	}

	public static void updateMap(int depth) {
		if (depth == 3) {
			int count = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 2) {
						count+= bfs(i, j);
					}
				}
			}
			minCount = Math.min(minCount, count);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					updateMap(depth + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static int bfs(int row, int column) {
		int count = 0;
		Queue<Node> q = new LinkedList<>();
		visited[row][column] = true;
		q.offer(new Node(row, column));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | nx >= N | ny < 0 | ny >= M)
					continue;
				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					count++;
					q.offer(new Node(nx, ny));
				}
			}
		}
		return count;
	}
}

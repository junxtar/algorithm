package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2573 {

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
	static int count = 0;
	static int year = 0;
	static int[][] map;
	static int[][] result;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				result[i][j] = value;
			}
		}
		int cnt = 0;
		int year = 0;
		while ((cnt = Separate()) < 2) {
			if (cnt == 0) {
				year = 0;
				break;
			}
			Melt();
			year++;
		}
		System.out.println(year);
	}

	static void dfs(int row, int column, boolean[][] visited) {
		visited[row][column] = true;
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = column + dy[i];
			if (nx < 0 | nx >= N | ny < 0 | ny >= M)
				continue;
			if (map[nx][ny] != 0 && !visited[nx][ny]) {
				dfs(nx, ny, visited);
			}
		}
	}

	static void Melt() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 & !visited[i][j]) {
					q.offer(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | nx >= N | ny < 0 | ny >= M)
					continue;
				if (map[nx][ny] == 0) {
					result[cur.x][cur.y]--;
					if (result[cur.x][cur.y] < 0) {
						result[cur.x][cur.y] = 0;
					}
				}
				if (!visited[nx][ny] && map[nx][ny] != 0) {
					visited[nx][ny] = true;
				}
			}
		}
		copy();
	}

	static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = result[i][j];
			}
		}
	}
	static int Separate() {
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, visited);
					cnt++;
				}
			}
		}
		return cnt;
	}

}

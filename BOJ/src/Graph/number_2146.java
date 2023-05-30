package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2146 {

	static class Node {
		int x;
		int y;
		int z;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int N;
	static int result = Integer.MAX_VALUE;
	static int groupNum = 0;
	static boolean[][] visited;
	static int[][] map;
	static int[] dxy = { 1, 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					setGroupNumber(i, j);
					groupNum++;
				}
			}
		}
		
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					setBridge(i, j, map[i][j]);
					visited = new boolean[N][N];
				}
			}
		}
		System.out.println(result == Integer.MAX_VALUE ? 0 : result);
	}

	static void setGroupNumber(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col));
		visited[row][col] = true;
		map[row][col] += groupNum;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = dxy[i] + cur.x;
				int ny = dxy[i + 1] + cur.y;

				if (nx < 0 | ny < 0 | nx >= N | ny >= N)
					continue;

				if (!visited[nx][ny] && map[nx][ny] != 0) {
					map[nx][ny] += groupNum;
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
				}
			}
		}
	}

	static void setBridge(int row, int col, int groupNum) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0));
		visited[row][col] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (result < cur.z)
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = dxy[i] + cur.x;
				int ny = dxy[i + 1] + cur.y;

				if (nx < 0 | ny < 0 | nx >= N | ny >= N)
					continue;
				if (visited[nx][ny] || map[nx][ny] == groupNum)
					continue;
				if (map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, cur.z + 1));

				} else {
					result = Math.min(result, cur.z);
				}
			}
		}
	}
}

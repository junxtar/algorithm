package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_4179 {

	static class Node {
		int x;
		int y;
		int z;
		int type;

		Node(int x, int y, int z, int type) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.type = type;
		}
	}

	static int N, M;
	static int startX, startY;
	static int fireX, fireY;
	static char[][] map;
	static boolean[][] visited;
	static ArrayList<Node> fire;
	static int[] dxy = { 1, 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		fire = new ArrayList<>();
		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'F') {
					fire.add(new Node(i, j, 0, 0));
				}
				if (map[i][j] == 'J') {
					startX = i;
					startY = j;
				}
			}
		}
		int result = bfs(startX, startY);
		System.out.println(result == -1 ? "IMPOSSIBLE" : result);
	}

	static int bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		for (Node cur : fire) {
			q.offer(new Node(cur.x, cur.y, cur.z, cur.type));
			visited[cur.x][cur.y] = true;
		}
		q.offer(new Node(row, col, 1, 1));
		visited[row][col] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (!visited[nx][ny] && map[nx][ny] == '.') {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, cur.z + 1, cur.type));
					}
				} else {
					if (cur.type == 1) {
						return cur.z;
					}
				}
			}
		}
		return -1;
	}
}

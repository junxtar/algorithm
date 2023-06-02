package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2638 {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int time = 0, count = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dxy = { 1, 0, -1, 0, 1 };
	static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					count++;
				}
			}
		}
		while (count > 0) {
			time++;
			list = new ArrayList<>();
			visited = new boolean[N + 2][M + 2];
			bfs(0, 0);
			for (Node cur : list) {
				if (blankCheck(cur.x, cur.y)) {
					map[cur.x][cur.y] = 2;
					
				}
			}
			setMap();
		}
		System.out.println(time);
	}

	static void bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col));
		visited[row][col] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 | ny < 0 | nx >= N + 2 | ny >= M + 2)
					continue;

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					if (map[nx][ny] == 0) {
						q.offer(new Node(nx, ny));
					}
					if (map[nx][ny] == 1) {
						list.add(new Node(nx, ny));
					}

				}
			}
		}
	}

	static boolean blankCheck(int row, int col) {
		int blankCount = 0;
		for (int i = 0; i < 4; i++) {
			int nx = row + dxy[i];
			int ny = col + dxy[i + 1];

			if (map[nx][ny] == 0 && visited[nx][ny]) {
				blankCount++;
			}
		}
		return blankCount > 1 ? true : false;
	}

	static void setMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
					count--;
				}
			}
		}
	}
}

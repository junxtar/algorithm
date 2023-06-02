package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2636 {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int count = 0, time = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dxy = { 1, 0, -1, 0, 1 };
	static ArrayList<Node> list;

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
				if (map[i][j] == 1) {
					count++;
				}
			}
		}
		int cnt = 0;
		while (count > 0) {
			list = new ArrayList<>();
			visited = new boolean[N][M];
			time++;
			cnt = bfs(0, 0);
			for (Node cur : list) {
				map[cur.x][cur.y] = 0;
				
			}
		}
		System.out.println(time);
		System.out.println(cnt);
	}

	static int bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col));
		visited[row][col] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 | ny < 0 | nx >= N | ny >= M)
					continue;

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					if (map[nx][ny] == 0) {
						q.offer(new Node(nx, ny));
					}
					if (map[nx][ny] == 1) {
						list.add(new Node(nx, ny));
						cnt++;
						count--;
					}
				}
			}
		}
		return cnt;
	}
}

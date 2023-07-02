package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_16234 {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Node> list;
	static int[] dxy = { 1, 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(simulation());

	}

	private static int simulation() {
		int result = 0;
		while (true) {
			visited = new boolean[N][N];
			boolean isMove = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						int sum = bfs(i, j);
						if (list.size() > 1) {
							personMove(sum);
							isMove = true;
						}
					}
				}
			}
			if (!isMove) {
				return result;
			}
			result++;
		}
	}

	private static int bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();
		list.add(new Node(row, col));
		q.offer(new Node(row, col));
		visited[row][col] = true;
		
		int sum = map[row][col];
		
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 | ny < 0 | nx >= N | ny >= N)
					continue;
				if (visited[nx][ny])
					continue;
				
				int value = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
				if (value >= L && value <= R) {
					q.offer(new Node(nx, ny));
					list.add(new Node(nx, ny));
					sum += map[nx][ny];
					visited[nx][ny] = true;

				}
			}
		}
		return sum;
	}

	private static void personMove(int sum) {
		int value = sum / list.size();
		for (Node cur : list) {
			map[cur.x][cur.y] = value;
		}
	}
}

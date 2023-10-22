package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_26009 {

	static class Node {
		int x;
		int y;
		int z;

		Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int N, M;
	static int[] dxy = { 1, 0, -1, 0, 1 };
	static int[] dx = {-1, 1, 1, -1};
	static int[] dy = {1, 1, -1, -1};
	static int[][] map;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		map = new int[N][M];
		visited = new boolean[N][M];
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;

			int distance = Integer.parseInt(st.nextToken());
			if (distance == 0) {
				visited[row][col] = true;
				continue;
			}
			trafficCongestion(row, col, distance);
		}

		int result = bfs(0, 0);
		boolean isSuccess = result == -1 ? false : true;
		if (isSuccess) {
			sb.append("YES").append("\n").append(result);
		} else {
			sb.append("NO");
		}

		System.out.println(sb.toString());

	}

	static void trafficCongestion(int row, int col, int distance) {
		int nx = row; 
		int ny = col - distance; 
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < distance; j++) {
				nx += dx[i];
				ny += dy[i];
				
				if (nx < 0 | ny < 0 | nx >= N | ny >= M)
					continue;
				visited[nx][ny] = true;
			}
		}

	}

	static int bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0));
		visited[row][col] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.z;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 | ny < 0 | nx >= N | ny >= M)
					continue;

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, cur.z + 1));
				}
			}
		}
		return -1;
	}
}

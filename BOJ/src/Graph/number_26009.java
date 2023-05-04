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
	static int[] dxy = {1, 0, -1, 0, 1}; 
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
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
			trafficCongestion(row, col, distance);
		}
	
	
//		bfs(0, 0);
//		if (map[N-1][M-1] == 0) {
//			System.out.println("NO");
//			return;
//		}
//		sb.append("YES").append("\n").append(map[N-1][M-1]);
//		System.out.println(sb.toString());

	}

	static void trafficCongestion(int row, int col, int distance) {
		
		for (int i = row - distance; i <= row + distance; i++) {
			for (int j = col - distance; j <= col + distance; j++) {
				if (Math.abs(i - row) + Math.abs(j - col) == distance) {
					if (i < 0 | i >=N| j < 0 | j >= M)	continue;
					visited[i][j] = true;
				}
			}
		}
		
	}

	static void bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0));
		visited[row][col] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i+1];

				if (nx < 0 | ny < 0 | nx >= N | ny >= M)
					continue;

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					map[nx][ny] = cur.z + 1;
					q.offer(new Node(nx, ny, cur.z + 1));
				}
			}
		}
	}

}

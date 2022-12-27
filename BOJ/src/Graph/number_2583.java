package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2583 {

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
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		int count = 0;
		int K = Integer.parseInt(st.nextToken());

		while (K-- > 0) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = N - y2; i < N - y2 + (y2 - y1); i++) {
				for (int j = x1; j < x2; j++) {
					map[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					bfs(i,j);
					count += 1;
				}
			}
		}
		Collections.sort(list);
		sb.append(count).append("\n");
		for(int data: list) {
			sb.append(data).append(" ");
		}
		System.out.println(sb);
	}

	static void bfs(int row, int column) {
		Queue<Node> q = new LinkedList<>();
		int count = 0;
		q.offer(new Node(row, column));
		visited[row][column] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			count++;
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | nx >= N | ny < 0 | ny >= M)
					continue;

				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					q.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		list.add(count);
	}

}

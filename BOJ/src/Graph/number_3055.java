package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_3055 {

	static class Node {
		int x;
		int y;
		int type;

		Node(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<>();
	static int[] dxy = { 1, 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int startX = 0, startY = 0;
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '*') {
					q.offer(new Node(i, j, 1));
					visited[i][j] = true;
				}
				if (map[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}
		System.out.println(bfs(startX, startY));
	}
	
	static String bfs(int row, int col) {
		int[][] dist = new int[R][C];
		q.offer(new Node(row, col, 0));
		visited[row][col] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
		
			if (cur.type == 0 && map[cur.x][cur.y] == 'D') {
				return String.valueOf(dist[cur.x][cur.y]);
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];
				
				if (nx < 0 | nx >= R | ny < 0 | ny >= C) continue;
				// 두더지
				if (cur.type == 0) {
					if (!visited[nx][ny] && map[nx][ny] == '.' || map[nx][ny] == 'D') {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, 0));
						dist[nx][ny] = dist[cur.x][cur.y] + 1;
					} 
				// 물 
				}
				if (cur.type == 1) {
					if (!visited[nx][ny] && map[nx][ny] == '.' || map[nx][ny] == 'S') {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, 1));
					}
				}
			}
		}
		return "KAKTUS";
	}
}

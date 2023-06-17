package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2589 {

	static class Node {
		int x;
		int y;
		int z;
		
		Node (int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static int N, M;
	static int max = 0;
	static char[][] map;
	static boolean[][] visited;
	static int[] dxy = {1, 0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					visited = new boolean[N][M];
					max = Math.max(bfs(i, j), max);
				}
			}
		}
		System.out.println(max);
	}
	static int bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0));
		visited[row][col] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			cnt = Math.max(cnt, cur.z);
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];
				
				if (nx < 0 | nx >= N | ny < 0 | ny >= M)  continue;
				
				if (!visited[nx][ny] && map[nx][ny] == 'L') {
					q.offer(new Node(nx, ny, cur.z + 1));
					visited[nx][ny] = true;
				}
			}
		}
		return cnt;
	}
}

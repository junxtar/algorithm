package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_7569 {
	
	static class Node {
		int x;
		int y;
		int h;
		int z;
		
		Node (int x, int y, int h, int z) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.z = z;
		}
	}
	static int count = 0;
	static int max = 0;
	static int N, M, H;
	static int[][][] map;
	static boolean[][][] visited;
	static Queue<Node> q = new LinkedList<>(); 
	static int[] dxy = {1, 0, 0, -1, 0, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][H];
		visited = new boolean[N][M][H];
		
		count = N * M * H;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if (map[j][k][i] == 1) {
						q.offer(new Node(j, k, i, 0));
						visited[j][k][i] = true;
					}
					if (map[j][k][i] == 1 || map[j][k][i] == -1) {
						count--;
					}
				}
			}
		}
		bfs();
		if (count == 0) {
			System.out.println(max);
			return;
		}
		System.out.println(-1);
	}
	static void bfs() {
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			max = Math.max(max, cur.z);
			
			for (int i = 0; i < 6; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];
				int nh = cur.h + dxy[i + 2];
				
				if (nx < 0 | ny < 0 | nh < 0 | nx >= N | ny >= M | nh >= H) continue;
				
				if(!visited[nx][ny][nh] && map[nx][ny][nh] == 0) {
					visited[nx][ny][nh] = true;
					q.offer(new Node(nx, ny, nh, cur.z + 1));
					count--;
				}
			}
		}
	}
}

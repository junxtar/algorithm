package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_6087 {

	static class Node {
		int x;
		int y;
		int w;
		int dir;
		Node(int x, int y, int w,int dir) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.dir = dir;
		}
	}

	static int W, H;
	static int endX, endY = 0;
	static int[][][] dist;
	static char[][] map;
	static final int INF = 10001;
	static int[] dxy = { 1, 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		dist = new int[H][W][2];
		map = new char[H][W];
		int startX = -1;
		int startY = -1;
		
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				Arrays.fill(dist[i][j], INF);
				char element = str.charAt(j);
				map[i][j] = element;
				if (element == 'C' && startX == -1) {
					startX = i;
					startY = j;
				}
				if (element == 'C' && startX != -1) {
					endX = i;
					endY = j;
				}
				if (element == '*')
					continue;
			}
		}
		System.out.println(dijkstra(startX, startY)); 
	}
	
	static int dijkstra(int startX, int startY) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(startX, startY, 0, 0));
		pq.offer(new Node(startX, startY, 0, 1));
		dist[startX][startY][0] = 0;
		dist[startX][startY][1] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (dist[cur.x][cur.y][cur.dir] < cur.w) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];
				
				if (nx < 0 | nx >= H | ny < 0 | ny >= W) continue;
				if (map[nx][ny] == '*') continue;
				
				int dir = i % 2; 
				
				int turn = dir == cur.dir || cur.dir == 4 ? 0 : 1;
				
				if (dist[nx][ny][dir] > cur.w + turn) {
					dist[nx][ny][dir] = cur.w + turn;
					pq.offer(new Node(nx, ny, dist[nx][ny][dir], dir));
				} 
			}
		}
		return Math.min(dist[endX][endY][0], dist[endX][endY][1]);
	}
}

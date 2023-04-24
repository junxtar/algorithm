package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_6087 {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int W, H;
	static int endX, endY = 0;
	static int[][] dist;
	static char[][] map;
	static Node[][] nodeMap;
	static int[] dxy = { 1, 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		dist = new int[H][W];
		map = new char[H][W];
		nodeMap = new Node[H][W];
		int startX = 0;
		int startY = 0;

		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				char element = str.charAt(j);
				map[i][j] = element;
				nodeMap[i][j] = new Node(0, 0);
				if (element == 'C') {
					startX = i;
					startY = j;
				}
				if (element == '*')
					continue;
				dist[i][j] = Integer.MAX_VALUE;

			}
		}

		dijkstra(startX, startY);
		
		int flag = 0;
		boolean isX = false;
		int x, y = 0;
		x = endX;
		y = endY;
		int cnt = 0;
		if (endX != nodeMap[endX][endY].x) {
			flag = endX;
			isX = true;
		} else {
			flag = endY;
		}
		
		while (nodeMap[endX][endY].x != 0 && nodeMap[endX][endY].y != 0) {
			endX = nodeMap[x][y].x; 
			endY = nodeMap[x][y].y; 
			x = endX;
			y = endY;
			if (!isX) {
				if (endY == flag) {
					isX = true;
					cnt++;
					flag = endX;
				} else {
					flag = endY; 
				}

			} else {
				if (endX == flag) {
					isX = false;
					cnt++;
					flag = endY;
				} else {
					flag = endX;
				}
			}
		}
		System.out.println(cnt);
	}

	static void dijkstra(int startX, int startY) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(startX, startY));
		dist[startX][startY] = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (map[cur.x][cur.y] == 'C' && cur.x != startX && cur.y != startY) {
				endX = cur.x;
				endY = cur.y;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 | nx >= H | ny < 0 | ny >= W)
					continue;
				if (map[nx][ny] == '*')
					continue;
				if (dist[nx][ny] > dist[cur.x][cur.y] + 1) {
					dist[nx][ny] = dist[cur.x][cur.y] + 1;
					nodeMap[nx][ny] = new Node(cur.x, cur.y);

					q.offer(new Node(nx, ny));
				}
			}
		}
	}
}

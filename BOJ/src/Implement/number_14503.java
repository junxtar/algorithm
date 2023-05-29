package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_14503 {

	static class Node {
		int x;
		int y;
		int dir;

		Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static int N, M;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }; // 북 동 남 서
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(search(row, col, dir));
	}

	static int search(int row, int col, int dir) {
		int count = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, dir));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (map[cur.x][cur.y] == 0) {
				map[cur.x][cur.y] = 2;
				count++;
			}
			boolean isClean = true;
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[(cur.dir - i + 7) % 4];
				int ny = cur.y + dy[(cur.dir - i + 7) % 4];

				if (map[nx][ny] == 0) {
					q.offer(new Node(nx, ny, (cur.dir - i + 7) % 4));
					isClean = false;
					break;
				}
			}
			// 만약 청소할 곳이 남아 있지 않다면
			if (isClean) {
				if (cur.dir == 0) {
					if (map[cur.x + 1][cur.y] == 1) {
						return count;
					}
					q.offer(new Node(cur.x + 1, cur.y, cur.dir));
				} else if (cur.dir == 1) {
					if (map[cur.x][cur.y - 1] == 1) {
						return count;
					}
					q.offer(new Node(cur.x, cur.y - 1, cur.dir));
				} else if (cur.dir == 2) {
					if (map[cur.x - 1][cur.y] == 1) {
						return count;
					}
					q.offer(new Node(cur.x - 1, cur.y, cur.dir));
				} else if (cur.dir == 3) {
					if (map[cur.x][cur.y + 1] == 1) {
						return count;
					}
					q.offer(new Node(cur.x, cur.y + 1, cur.dir));
				}
			}
		}
		return count;
	}
}

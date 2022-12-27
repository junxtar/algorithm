package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_7576 {
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
	static int[]dx = {-1, 1, 0, 0};
	static int[]dy = {0, 0, 1, -1};
	static int[][] map;
	static Queue<Node>q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
				}else if(map[i][j] == 1) {
					q.offer(new Node(i,j));
				}
			}
		}
		System.out.println(bfs());
		
	}
	static int bfs() {
			while(!q.isEmpty()) {
				Node cur = q.poll();
				for(int i = 0; i<4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if(map[nx][ny] == 0) {
						map[nx][ny] = 1;
						map[nx][ny] += map[cur.x][cur.y];
						q.offer(new Node(nx, ny));
					}
				}
				
			}
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0)
						return -1;
					max = Math.max(max, map[i][j]);
				}
			}
			return max-1;
		}
		
	}

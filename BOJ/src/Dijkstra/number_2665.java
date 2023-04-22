package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class number_2665 {

	static class Node {
		int x;
		int y;
		int w;
		
		Node (int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int N;
	static int[][] cost;
	static int[][] map;
	static int[] dxy = {1, 0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][N];
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			Arrays.fill(cost[i], Integer.MAX_VALUE);
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) == '0' ? 1 : 0;
			}
		}
		System.out.println(dijkstra(0, 0));
	}
	
	static int dijkstra(int row, int col) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		cost[row][col] = 0;
		pq.offer(new Node(row, col, cost[row][col]));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cost[cur.x][cur.y] < cur.w) continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];
				
				if (nx < 0 | nx >= N | ny < 0 | ny >= N) continue;
				
				if (cost[nx][ny] > cost[cur.x][cur.y] + map[nx][ny]) {
					cost[nx][ny] = cost[cur.x][cur.y] + map[nx][ny];
					pq.offer(new Node(nx, ny, cost[nx][ny]));
				}
			}
		}
		return cost[N - 1][N - 1];
	}

}

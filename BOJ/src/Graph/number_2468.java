package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2468 {
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int height = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max = 0;
		int result = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		while(height < max) {
			int count = 0;
			visited = new boolean[N][N];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(!visited[i][j] && map[i][j] > height) {
						bfs(i,j);
						count++;
					}
				}
			}
			height++;
			result = Math.max(count, result);
		}
		
		System.out.println(result);
	}
	static void bfs(int row, int column) {
		Queue<Node>q = new LinkedList<>();
		q.offer(new Node(row, column));
		visited[row][column] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 | nx >= N | ny < 0 | ny >= N) {
					continue;
				}
				if(map[nx][ny]>height && !visited[nx][ny]) {
					q.offer(new Node(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

}

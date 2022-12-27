package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class number_10026 {
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
		static int N;
		static char[][] map;
		static boolean[][] visited;
		static int[] dx = {1, -1, 0, 0};
		static int[] dy = {0, 0, 1, -1};
		static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int count = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		sb.append(count).append(" ");
		count = 0;
		visited = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
	static void bfs(int row, int column) {
		Queue<Node>q = new LinkedList<>();
		q.offer(new Node(row, column));
		visited[row][column] = true;
		while(!q.isEmpty()){
			Node cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(map[cur.x][cur.y] == map[nx][ny] && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Node(nx,ny));
				}
			}
			if(map[cur.x][cur.y] == 'G')
				map[cur.x][cur.y] = 'R';
		}
	}

}

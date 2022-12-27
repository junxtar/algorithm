package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class number_2667 {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static ArrayList<Integer>list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		list = new ArrayList<>();
		
		
		for(int i = 0; i<N; i++) {
			String line = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		Collections.sort(list);
		
		sb.append(list.size()).append("\n");
		for(int data: list) {
			sb.append(data).append("\n");
		}
			
		System.out.println(sb);
	}
	static void bfs(int row, int column) {
		Queue<Node>q = new LinkedList<>();
		int count = 0;
		map[row][column]++;
		q.offer(new Node(row, column));
		while(!q.isEmpty()) {
			Node n = q.poll();
			count++;
			for(int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if(map[nx][ny] == 1) {
					q.offer(new Node(nx, ny));
					map[nx][ny]++;
					
				}
			}
		}
		list.add(count);
	}

}

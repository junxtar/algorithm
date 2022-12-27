package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_11724 {
	static int[][] map;
	static int N, M;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		int count = 0;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(map[i][j] == 1 && !visited[i]) {
					dfs(i);
					count++;
				}
			}
		}
		for(boolean visitCount : visited) {
			if(!visitCount) {
				count++;
			}
		}
		System.out.println(count-1);
	}
	static void dfs(int v) {
		visited[v] = true;
		for(int i = 1; i<=N; i++) {
			if(map[v][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}

}

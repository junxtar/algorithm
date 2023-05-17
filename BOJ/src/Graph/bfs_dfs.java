package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_dfs {
	static int n, m, v;
	static int[][]map;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		bfs(v);
		sb.append("\n");
		dfs(v);
		System.out.println(sb);
				
	}
	public static void dfs(int v) {
		if(!visit[v]) {
			visit[v] = true;
			sb.append(v+" ");
		}
		for(int i = 1; i<=n; i++) {
			if(!visit[i] && map[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Arrays.fill(visit, false);
		Queue<Integer>queue = new LinkedList<>();
		visit[v] = true;
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			sb.append(p+" ");
			for(int i = 1; i<=n; i++) {
				if(!visit[i] && map[p][i]==1) {
					visit[i] = true;
					queue.offer(i);
					
					
				}
			}
		}
	}

}

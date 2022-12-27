package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_11403 {
	
	static int N;
	static int[][] grapgh;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		grapgh = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				grapgh[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				sb.append(bfs(i,j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static int bfs(int row, int column) {
		visited = new boolean[N+1];
		Queue<Integer>q = new LinkedList<>();
		q.offer(row);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 1; i<=N; i++) {
				if(grapgh[cur][i]==1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
					if(i == column) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
}

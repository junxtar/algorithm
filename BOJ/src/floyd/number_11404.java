package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_11404 {
	
	static class Node {
		int x;
		int y;
		int w;
	}
	
	static int N;
	static int[][] dist;
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		dist = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = INF;
			}
		}
		StringTokenizer st;
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dist[u][v] = Math.min(dist[u][v], w);
		}
		
		floyd();
		for (int i = 1; i < dist.length; i++) {
			for (int j = 1; j < dist.length; j++) {
				if(dist[i][j] >= INF) {
					sb.append("0 ");
					continue;
				}
				sb.append(dist[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void floyd () {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (dist[j][k] > dist[j][i] + dist[i][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
					}
				}
			}
		}
	}
}

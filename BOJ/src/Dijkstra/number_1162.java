package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1162 {
	
	static class Node {
		int v, cnt;
		long w;
		
		Node(int v, long w, int cnt) {
			this.v = v;
			this.w = w;
			this.cnt = cnt;
		}
	}
	static int N, M, K;
	static long[][] dp;
	static final long INF = Long.MAX_VALUE;
	static ArrayList<ArrayList<Node>> grapgh;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new long[N + 1][K + 1];
		grapgh = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			grapgh.add(new ArrayList<>());
			Arrays.fill(dp[i], INF);
		}
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			grapgh.get(u).add(new Node(v, w, 0));
			grapgh.get(v).add(new Node(u, w, 0));
		}
		
		dijkstra(1);
		long result = INF;
		for (long value : dp[N]) {
			result = Math.min(value, result);
		}
		System.out.println(result);
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o1 -> o1.w));
		dp[start][0] = 0;
		pq.offer(new Node(start, dp[start][0], 0));
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			if (cur.w > dp[cur.v][cur.cnt]) continue;
			
			for (Node next : grapgh.get(cur.v)) {
				if (dp[next.v][cur.cnt] > next.w + cur.w) {
					dp[next.v][cur.cnt] = next.w + cur.w;
					pq.offer(new Node(next.v, dp[next.v][cur.cnt], cur.cnt));
				}
				
				if(cur.cnt < K && cur.w < dp[next.v][cur.cnt + 1]) {
					dp[next.v][cur.cnt + 1] = cur.w;
					pq.offer(new Node(next.v, cur.w, cur.cnt + 1));
				}
			}
		}
	}
}

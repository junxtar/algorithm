package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2637 {

	static class Node {
		int v;
		int cnt;

		Node(int v, int cnt) {
			this.v = v;
			this.cnt = cnt;
		}
	}
	
	static int N;
	static int[] seq;
	static int[][] dp;
	static ArrayList<ArrayList<Node>> grapgh;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		seq = new int[N + 1];
		dp = new int[N + 1][N + 1];
		grapgh = new ArrayList<>();
		
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		while (M --> 0 ) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(new Node(v, cnt));
			seq[v]++;
		}
		topologicalSort();
		for (int i = 1; i < N + 1; i++) {
			if(dp[N][i] != 0) {
				sb.append(i).append(" ").append(dp[N][i]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	static void topologicalSort() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 1; i < seq.length; i++) {
			if(seq[i] == 0) {
				q.offer(new Node(i, 0));
				dp[i][i] = 1;
			}
		}
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (Node next : grapgh.get(cur.v)) {
				seq[next.v]--;
				for (int i = 1; i < N + 1; i++) {
					dp[next.v][i] += dp[cur.v][i] * next.cnt;
				}
				
				if(seq[next.v] == 0) {
					q.offer(next);
				}
			}
		}
	}
}

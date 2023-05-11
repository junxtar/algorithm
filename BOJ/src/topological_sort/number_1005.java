package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_1005 {
	
	static int N, M;
	static int[] seq;
	static int[] value;
	static int[] dp;
	static ArrayList<ArrayList<Integer>> grapgh;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			seq = new int[N + 1];
			value = new int[N + 1];
			dp = new int[N + 1];
			grapgh = new ArrayList<>();
			
			for (int i = 0; i < N + 1; i++) {
				grapgh.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				value[i] = Integer.parseInt(st.nextToken());
			}
			while(M --> 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				seq[v]++;
				grapgh.get(u).add(v);
			}
			int destination = Integer.parseInt(br.readLine());
			sb.append(topologicalSort(destination)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int topologicalSort(int destination) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < seq.length; i++) {
			if(seq[i] == 0) {
				q.offer(i);
				dp[i] = value[i];
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if (seq[destination] == 0) {
				break;
			}
			
			for(int next : grapgh.get(cur)) {
				seq[next]--;
				dp[next] = Math.max(dp[next], value[next] + dp[cur]);
				if(seq[next] == 0) {
					q.offer(next);
				}
			}
		}
		return dp[destination];
	}
}

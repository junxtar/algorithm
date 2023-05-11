package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_1516 {

	static int N;
	static int[] seq;
	static int[] values;
	static int[] dp;
	static ArrayList<ArrayList<Integer>> grapgh;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		grapgh = new ArrayList<>();
		seq = new int[N + 1];
		values = new int[N + 1];
		dp = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			values[i] = value;
			int v = Integer.parseInt(st.nextToken());
			while(v != -1) {
				seq[i]++;
				grapgh.get(v).add(i);
				v = Integer.parseInt(st.nextToken());
			}
		}
		topologicalSort();
		for (int i = 1; i < dp.length; i++) {
			sb.append(dp[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < seq.length; i++) {
			if(seq[i] == 0) {
				q.offer(i);
				dp[i] = values[i];
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : grapgh.get(cur)) {
				dp[next] = Math.max(dp[next], dp[cur] + values[next]);
				seq[next]--;
				if(seq[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}

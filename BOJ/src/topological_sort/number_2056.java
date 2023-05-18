package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2056 {

	static int N;
	static int[] seq;
	static int[] dp;
	static int[] values;
	static ArrayList<ArrayList<Integer>> grapgh;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		seq = new int[N + 1];
		dp = new int[N + 1];
		values = new int[N + 1];
		grapgh = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			values[i] = value;
			while (cnt-- > 0) {
				int v = Integer.parseInt(st.nextToken());
				grapgh.get(i).add(v);
				seq[v]++;
			}
		}
		System.out.println(topologicalSort());
	}

	static int topologicalSort() {
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
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}

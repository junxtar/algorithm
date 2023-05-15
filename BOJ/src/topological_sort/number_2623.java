package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2623 {

	static int N, M;
	static int cnt = 0;
	static int[] seq;
	static ArrayList<ArrayList<Integer>> grapgh;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		seq = new int[N + 1];
		grapgh = new ArrayList<>();

		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());

			for (int i = 1; i < cnt; i++) {
				int v = Integer.parseInt(st.nextToken());
				seq[v]++;
				grapgh.get(u).add(v);
				u = v;
			}
		}
		topologicalSort();
		if (cnt == N) {
			System.out.println(sb.toString());
			return;
		}
		System.out.println(0);	
	}
	
	static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < seq.length; i++) {
			if(seq[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if(seq[cur] == 0) {
				cnt++;
				sb.append(cur).append("\n");
			}
			for (int next : grapgh.get(cur)) {
				seq[next]--;
				
				if(seq[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}

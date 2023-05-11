package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2252 {

	static int N, M;
	static int[] seq;
	static ArrayList<ArrayList<Integer>> grapgh;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grapgh = new ArrayList<>();
		seq = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		while (M --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			seq[v]++;
			grapgh.get(u).add(v);
		}
		topologicalSort();
		System.out.println(sb.toString());
	}
	
	static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < seq.length; i++) {
			if (seq[i] == 0) {
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(seq[cur] == 0) {
				sb.append(cur).append(" ");
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

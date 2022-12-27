package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_24444 {
	static int N, M, V;
	static StringBuilder sb = new StringBuilder();
	static int[] visit;
	static int count = 1;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visit = new int[N + 1];
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}
		bfs(V);
		for (int i = 1; i <= N; i++) {
			sb.append(visit[i] + "\n");
		}
		System.out.println(sb);

	}

	public static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		visit[V] = count++;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int data : list.get(temp)) {
				if (visit[data] == 0) {
					queue.offer(data);
					visit[data] = count++;
				}
			}
		}

	}
}

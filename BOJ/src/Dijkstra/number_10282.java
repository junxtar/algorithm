package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_10282 {

	static class Node {
		int v;
		int s;

		Node(int v, int s) {
			this.v = v;
			this.s = s;
		}
	}

	static StringBuilder sb = new StringBuilder();
	static final int INF = 1000000000;
	static int[] cost;
	static ArrayList<ArrayList<Node>> grapgh;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			cost = new int[N + 1];
			Arrays.fill(cost, INF);

			grapgh = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				grapgh.add(new ArrayList<>());
			}

			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				grapgh.get(u).add(new Node(v, s));
			}
			dijkstra(start);
		}
		System.out.println(sb.toString());

	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.s - o2.s);
		cost[start] = 0;
		pq.offer(new Node(start, cost[start]));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cost[cur.v] < cur.s)
				continue;

			for (Node next : grapgh.get(cur.v)) {
				if (cost[next.v] > cur.s + next.s) {
					cost[next.v] = cur.s + next.s;
					pq.offer(new Node(next.v, cost[next.v]));
				}
			}
		}
		int count = 0;
		int max = 0;
		for (int i = 1; i < cost.length; i++) {
			if (cost[i] != INF) {
				count++;
				if (cost[i] > max) {
					max = cost[i];
				}
			}
		}
		sb.append(count + " " + max).append("\n");
	}

}

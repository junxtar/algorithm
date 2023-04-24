package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_2211 {

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int N;
	static final int INF = 10001;
	static int[] nodeArray;
	static int[] cost;
	static ArrayList<ArrayList<Node>> grapgh;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		grapgh = new ArrayList<>();

		cost = new int[N + 1];
		nodeArray = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(cost, INF);
		for (int i = 0; i <= N; i++) {
			grapgh.add(new ArrayList<>());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
		}
		dijkstra(1);
		int cnt = 0;
		for (int i = 2; i < N + 1; i++) {
			if (nodeArray[i] != 0) {
				cnt++;
				sb.append(i+" "+nodeArray[i]).append("\n");
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		cost[start] = 0;
		pq.offer(new Node(start, cost[start]));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.w > cost[cur.v])
				continue;

			for (Node next : grapgh.get(cur.v)) {
				if (cost[next.v] > cur.w + next.w) {
					cost[next.v] = cur.w + next.w;

					nodeArray[next.v] = cur.v;
					pq.offer(new Node(next.v, cost[next.v]));
				}
			}
		}
	}
}

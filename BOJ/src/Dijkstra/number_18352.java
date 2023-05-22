package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_18352 {

	static class Node {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int N;
	static int[] cost;
	static ArrayList<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Node>> grapgh;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);

		grapgh = new ArrayList<>();

		for (int i = 0; i < cost.length; i++) {
			grapgh.add(new ArrayList<>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(new Node(v, 1));
		}
		dijkstra(start, K);
		System.out.println(sb.toString());
	}

	static void dijkstra(int start, int K) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		cost[start] = 0;
		pq.offer(new Node(start, cost[start]));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cost[cur.v] < cur.w || cur.w >= K)
				continue;

			for (Node next : grapgh.get(cur.v)) {
				if (cost[next.v] > next.w + cur.w) {
					cost[next.v] = next.w + cur.w;
					pq.offer(new Node(next.v, cost[next.v]));
				}
			}
		}
		for (int i  = 1; i < cost.length; i++) {
			if (cost[i] == K) {
				list.add(i);
			}
		}
		Collections.sort(list);
		if (list.isEmpty()) {
			sb.append(-1);
			return;
		}
		for (int data : list) {
			sb.append(data).append("\n");
		}
	}
}

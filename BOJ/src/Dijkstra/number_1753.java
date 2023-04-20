package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1753 {

	static class Node {
		int v;
		int w;
		
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static int[] cost;
	static ArrayList<ArrayList<Node>>grapgh;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		cost = new int[V + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		grapgh = new ArrayList<>();
		for (int i = 0; i < cost.length; i++) {
			grapgh.add(new ArrayList<>());
			
		}
	
		while (E --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(new Node(v, w));
		}
		
		dijkstra(K);
		
		for (int i = 1; i < cost.length; i++) {
			sb.append(cost[i] == Integer.MAX_VALUE ? "INF" : cost[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		cost[start] = 0;
		pq.offer(new Node(start, cost[start]));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for (Node next : grapgh.get(cur.v)) {
				if (cost[next.v] > cur.w + next.w) {
					cost[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, cost[next.v]));
				}
			}
			
		}
	}
}

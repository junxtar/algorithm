package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1504 {

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
	static ArrayList<ArrayList<Node>>grapgh;
	static final int INF = 200000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		cost = new int[N+1];
		grapgh = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		while (E --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		
		int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		if (result1 >= INF && result2 >= INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(Math.min(result1, result2));
	}
	
	static int dijkstra(int start, int end) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		Arrays.fill(cost, INF);
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
		return cost[end];
	}
}

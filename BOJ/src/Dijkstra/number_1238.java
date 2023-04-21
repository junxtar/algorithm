package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1238 {

	static class Node {
		int v;
		int w;
		
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int[] cost;
	static ArrayList<ArrayList<Node>> grapgh;
	static final int INF = 10000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		cost = new int[N+1];
		
		grapgh = new ArrayList<>();
		
		for (int i = 0; i < cost.length; i++) {
			grapgh.add(new ArrayList<>());
		}
		
		while (M --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			grapgh.get(u).add(new Node(v, w));
		}
		
		for (int i = 1; i <= N; i++) {
			int res1 = dijkstra(i, X);
			int res2 = dijkstra(X, i);
			result = Math.max(res1 + res2, result);
		}
		System.out.println(result);
		
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		Arrays.fill(cost, INF);
		cost[start] = 0;
		pq.offer(new Node(start, cost[start]));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for (Node next : grapgh.get(cur.v)) {
				if (cost[next.v] > next.w + cur.w) {
					cost[next.v] = next.w + cur.w;
					pq.offer(new Node(next.v, cost[next.v]));
				}
			}
		}
		return cost[end];
	}

}

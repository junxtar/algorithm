package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1916 {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int M;
	static int[] cost;
	static ArrayList<ArrayList<Node>>grapgh;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		grapgh = new ArrayList<>();
		for(int i = 0; i<=N; i++){
			grapgh.add(new ArrayList<Node>());
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(new Node(v,cost));
		}
		

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(start, end));
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.y - o2.y;
			}
		});
		visited = new boolean[N + 1];
		pq.offer(new Node(start, 0));
		cost[start] = 0;
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.x;
			if (!visited[cur]) {
				visited[cur] = true;
				for(Node node : grapgh.get(cur)) {
					if (!visited[node.x] && cost[node.x] > cost[cur] + node.y) {
						cost[node.x] = cost[cur] + node.y;
						pq.offer(new Node(node.x, cost[node.x]));
					}
				}
			}
		}
		return cost[end];
	}

}

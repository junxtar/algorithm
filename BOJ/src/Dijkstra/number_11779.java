package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class number_11779 {

	static class Node {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static final int INF = 1000000000;
	static int N;
	static int[] cost;
	static int[] city;
	static ArrayList<ArrayList<Node>> grapgh;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[N + 1];
		city = new int[N + 1];
		Arrays.fill(cost, INF);

		grapgh = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			grapgh.add(new ArrayList<>());
		}
		int M = Integer.parseInt(br.readLine());

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(new Node(v, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		
		while (stack.peek() != start) {
			stack.push(city[stack.peek()]);
		}
		sb.append(cost[end]).append("\n");
		sb.append(stack.size()).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb.toString());

	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		cost[start] = 0;

		pq.offer(new Node(start, cost[start]));
		while (!pq.isEmpty()) {
			
			Node cur = pq.poll();
			
			if (cost[cur.v] < cur.w) continue;

			for (Node next : grapgh.get(cur.v)) {
				if (cost[next.v] > cur.w + next.w) {
					cost[next.v] = cur.w + next.w;
					city[next.v] = cur.v;
					pq.offer(new Node(next.v, cost[next.v]));
				}
			}
		}
	}
}

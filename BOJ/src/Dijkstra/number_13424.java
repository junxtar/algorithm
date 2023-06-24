package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_13424 {

	static class Node {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int N, M;
	static int[] dist;
	static int[] result;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> grapgh;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		while (T --> 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			result = new int[N + 1];
			grapgh = new ArrayList<>();
			
			for (int i = 0; i < N + 1; i++) {
				grapgh.add(new ArrayList<>());
			}
			while (M --> 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				grapgh.get(u).add(new Node(v, w));
				grapgh.get(v).add(new Node(u, w));
			}
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (K --> 0) {
				int node = Integer.parseInt(st.nextToken());
				dist = new int[N + 1];
				Arrays.fill(dist, Integer.MAX_VALUE);
				visited = new boolean[N + 1];
				dijkstra(node);
			}
			int value = Integer.MAX_VALUE;
			int nodeNumber = 0;
			for (int i = 1; i < result.length; i++) {
				if (value > result[i]) {
					value = result[i];
					nodeNumber = i;
				}
			}
			sb.append(nodeNumber).append("\n");
		
		}
		System.out.println(sb.toString());
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (dist[cur.v] < cur.w) continue;
			if (visited[cur.v]) continue;
			
			visited[cur.v] = true;
			
			for (Node next : grapgh.get(cur.v)) {
				if (!visited[next.v] && dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
			
		}
		for (int i = 1; i < result.length; i++) {
			result[i] += dist[i];
		}
	}

}

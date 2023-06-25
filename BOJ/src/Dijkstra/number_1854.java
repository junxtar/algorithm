package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1854 {

	static class Node {
		int v;
		int w;
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static int N, M, K;
	static int[] visitedCount;
	static ArrayList<PriorityQueue<Integer>> dist;
	static ArrayList<ArrayList<Node>> grapgh;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dist = new ArrayList<>();
		grapgh = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			dist.add(new PriorityQueue<>());
			grapgh.add(new ArrayList<>());
		}
		
		while (M --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			grapgh.get(u).add(new Node(v, w));
		}
		
		dijkstra(1);
		for (int i = 1; i <= N; i++) {
			if (dist.get(i).size() == K) {
				sb.append(dist.get(i).peek() * -1).append("\n");
				continue;
			}
			sb.append(-1).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(start, 0));
		dist.get(start).add(0);
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
						
			for (Node next : grapgh.get(cur.v)) {
				if (dist.get(next.v).size() < K) {
					dist.get(next.v).add((cur.w + next.w) * -1); 
					pq.offer(new Node(next.v, next.w + cur.w));
				} else if ((dist.get(next.v).peek() * -1) > cur.w + next.w) {
					dist.get(next.v).poll();
					dist.get(next.v).add((cur.w + next.w) * -1); 
					pq.offer(new Node(next.v, next.w + cur.w));
				}
			}
		}
	}
}

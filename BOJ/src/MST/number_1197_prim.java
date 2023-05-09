package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1197_prim {
	
	static class Node {
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static int V; 
	static int answer = 0;
	static int cnt = 0;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> grapgh;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		grapgh = new ArrayList<>();
		visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			grapgh.add(new ArrayList<>());
		}
		
		while(E --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
			
		}
		prim();
		System.out.println(answer);
	}
	static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.add(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			answer += cur.w;
			
			for (Node next : grapgh.get(cur.v)) {
				if(!visited[next.v]) {
					pq.add(next);
				}
			}
			if (cnt++ == V) break;
		}
	}
}

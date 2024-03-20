package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_14621 {

	static class Node {
		int v;
		int w;
		
		public Node (int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	private static int N;
	private static int M;
	private static int cnt = 0;
	private static int answer = 0;
	private static boolean[] visited;
	private static String[] sex;
	private static List<List<Node>> grapgh = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		init();
		prim();
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				answer = -1;
			}
		}
		System.out.println(answer);
	}
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sex = new String[N + 1];
		visited = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sex[i] = st.nextToken();
		}
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (sex[u].equals(sex[v])) {
				continue;
			}
			grapgh.get(u).add(new Node(v, w));
			grapgh.get(v).add(new Node(u, w));
		}
	}
	private static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.v]) {
				continue;
			}
			visited[cur.v] = true;
			answer += cur.w;
			
			for (Node next : grapgh.get(cur.v)) {
				if (!visited[next.v]) {
					pq.offer(next);
				}
			}
			if (cnt++ == N) {
				break;
			}
		}
	}
}

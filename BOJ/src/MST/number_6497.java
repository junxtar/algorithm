package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_6497 {

	static class Node {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int answer;
	static int V, E;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> grapgh;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if (V == 0 && E == 0)
				break;
			answer = 0;
			visited = new boolean[V + 1];
			grapgh = new ArrayList<>();

			for (int i = 0; i < V + 1; i++) {
				grapgh.add(new ArrayList<>());
			}
			int sum = 0;
			while (E-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				sum += w;

				grapgh.get(u).add(new Node(v, w));
				grapgh.get(v).add(new Node(u, w));
			}

			prim();
			sb.append(sum - answer).append("\n");
		}

		System.out.println(sb.toString());

	}

	static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.offer(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (visited[cur.v])
				continue;
			visited[cur.v] = true;
			answer += cur.w;

			for (Node next : grapgh.get(cur.v)) {
				if (visited[next.v])
					continue;
				pq.offer(next);
			}
		}
	}

}

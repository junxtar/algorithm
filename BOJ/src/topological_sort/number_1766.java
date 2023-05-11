package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1766 {

	static class Node {
		int v;
		int z;

		public Node(int v, int z) {
			this.v = v;
			this.z = z;
		}
	}

	static int N;
	static int M;
	static int[] seq;
	static ArrayList<ArrayList<Node>> grapgh;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		seq = new int[N + 1];
		grapgh = new ArrayList<>();
		
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			seq[v]++;
			grapgh.get(u).add(new Node(v, 0));
		}
		topologicalSort();
		System.out.println(sb.toString());
	}

	static void topologicalSort() {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.z == o2.z)
					return o1.v - o2.v;
				return o1.z - o2.z;
			}
		});

		for (int i = 1; i < seq.length; i++) {
			if (seq[i] == 0) {
				pq.offer(new Node(i, 0));
			}
		}

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (seq[cur.v] == 0) {
				sb.append(cur.v).append(" ");
			}
			for (Node next : grapgh.get(cur.v)) {
				seq[next.v]--;
				if (seq[next.v] == 0) {
					pq.offer(new Node(next.v, -1));
				}
			}
		}
	}
}

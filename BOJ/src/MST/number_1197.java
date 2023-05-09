package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//크루스칼 알고리즘 
public class number_1197 {

	static class Node implements Comparable<Node> {
		int u;
		int v;
		int w;

		public Node(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static int V;
	static int[] parents;
	static ArrayList<Node> nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		parents = new int[V + 1];
		nodeList = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			nodeList.add(new Node(u, v, w));
		}

		Collections.sort(nodeList);

		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
		int sum = 0;
		int cnt = 0;

		for (Node cur : nodeList) {
			if (union(cur.u, cur.v)) {
				sum += cur.w;
				cnt++;
				
				if(cnt == E - 1) break;
			}
		}
		System.out.print(sum);
	}

	private static boolean union(int u, int v) {
		int startRoot = findSet(u);
		int endRoot = findSet(v);

		if (startRoot == endRoot) {
			return false;
		}
		parents[startRoot] = endRoot;
		return true;
	}

	private static int findSet(int v) {
		if (parents[v] == v) {
			return v;
		}
		return parents[v] = findSet(parents[v]);

	}

}

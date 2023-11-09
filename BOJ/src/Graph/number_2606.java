package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2606 {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		node = new ArrayList<>();
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			node.add(new ArrayList<>());
		}
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			node.get(u).add(v);
			node.get(v).add(u);
		}

		bfs(1);
		int answer = 0;
		for (int i = 2; i < visited.length; i++) {
			if (visited[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		visited[i] = true;
		q.add(i);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int nx : node.get(cur)) {
				if (!visited[nx]) {
					visited[nx] = true;
					q.offer(nx);
				}
			}
		}
	}
}

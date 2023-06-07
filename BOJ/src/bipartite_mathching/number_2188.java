package bipartite_mathching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_2188 {

	static int N, M;
	static ArrayList<Integer>[] edges;
	static int[] house;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edges = new ArrayList[N];
		house = new int[M];
		visited = new boolean[M];
		Arrays.fill(house, -1);

		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while (s-- > 0) {
				edges[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (matching(i)) {
				cnt++;
				visited = new boolean[M];
			}
		}
		System.out.println(cnt);

	}

	static boolean matching(int cur) {
		for (int next : edges[cur]) {
			if (visited[next])
				continue;
			visited[next] = true;
			if (house[next] == -1 || matching(house[next])) {
				house[next] = cur;
				return true;
			}
		}
		return false;
	}
}

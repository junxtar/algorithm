package bipartite_mathching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_11376 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> edges;
	static int[] work;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[M];
		edges = new ArrayList<>();
		work = new int[M];
		Arrays.fill(work, -1);
		for (int i = 0; i < N * 2; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < N * 2; i += 2) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());

			while (s-- > 0) {
				int value = Integer.parseInt(st.nextToken()) - 1;
				edges.get(i).add(value);
				edges.get(i + 1).add(value);
			}
		}
		int cnt = 0;
		//matching 2번 사용 or list 2배로 늘려주기 
		for (int i = 0; i < N * 2; i++) {
			if (matching(i)) {
				cnt++;
				visited = new boolean[M];
			}
		}
		System.out.println(cnt);
	}

	static boolean matching(int cur) {
		for (int next : edges.get(cur)) {
			if (visited[next])
				continue;
			visited[next] = true;
			if (work[next] == -1 || matching(work[next])) {
				work[next] = cur;
				return true;
			}
		}
		return false;
	}
}

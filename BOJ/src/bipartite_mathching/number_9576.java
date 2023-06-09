package bipartite_mathching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_9576 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> edges;
	static int[] book;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			book = new int[N];
			visited = new boolean[N];
			edges = new ArrayList<>();
			Arrays.fill(book, -1);
			for (int i = 0; i < M; i++) {
				edges.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for (int j = a; j <= b; j++) {
					edges.get(i).add(j - 1);
				}
			}
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				if (matching(i)) {
					cnt++;
					visited = new boolean[N];
				}
			}
			System.out.println(cnt);
		}
	}
	
	static boolean matching(int cur) {
		for (int next : edges.get(cur)) {
			if (visited[next]) continue;
			visited[next] = true;
			
			if (book[next] == -1 || matching(book[next])) {
				book[next] = cur;
				return true;
			}
		}
		return false;
	}
}

package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_3665 {

	static String result;
	static int N;
	static int[] seq;
	static boolean[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			result = "";
			seq = new int[N + 1];
			map = new boolean[N + 1][N + 1];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				int rank = Integer.parseInt(st.nextToken());
				seq[rank] = i;
				for (int j = 1; j <= N; j++) {
					if (j != rank && !map[j][rank]) {
						map[rank][j] = true;
					}
				}
			}
			int M = Integer.parseInt(br.readLine());
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				swap(u, v);
			}

			sb.append(topological()).append("\n");
		}
		System.out.println(sb.toString());
	}

	static String topological() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < seq.length; i++) {
			if (seq[i] == 0) {
				q.offer(i);
			}
		}
		for (int i = 1; i <= N; i++) {
			if (q.isEmpty())
				return "IMPOSSIBLE";
			else if (q.size() > 1)
				return "?";
			int cur = q.poll();
			result += cur + " ";

			for (int j = 1; j <= N; j++) {
				if (map[cur][j]) {
					map[cur][j] = false;
					if (--seq[j] == 0) {
						q.offer(j);
					}
				}
			}
		}
		return result;
	}

	static void swap(int u, int v) {
		if (!map[u][v]) {
			map[u][v] = true;
			map[v][u] = false;
			seq[u]--;
			seq[v]++;
		} else {
			map[u][v] = false;
			map[v][u] = true;
			seq[u]++;
			seq[v]--;
		}
	}
}

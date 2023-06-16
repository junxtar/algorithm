package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_16928 {

	static int N, M;
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[101];
		for (int i = 1; i < map.length; i++) {
			map[i] = i;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u] = map[v];
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u] = map[v];
		}
		System.out.println(bfs(0));
	}

	static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] check = new int[101];
		q.offer(start);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 1; i <= 6; i++) {
				int nx = cur + i;
				if (nx > 100)
					continue;
				
				if (check[map[nx]] == 0) {
					q.offer(map[nx]);
					check[map[nx]] = check[cur] + 1;
				}
			}
		}
		return check[100];
	}
}

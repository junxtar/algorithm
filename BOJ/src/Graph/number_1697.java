package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_1697 {
	static int N;
	static int X;
	static int second = 1;
	static int[] visited = new int[100001];
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		System.out.println(bfs(N));
	}

	static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		int size = 1;
		q.offer(n);
		visited[n] = second;
		while (!q.isEmpty()) {
			second++;
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				list.add(temp);
			}
			for (int i = 0; i < list.size(); i++) {
				int cur = list.get(i);
				if (cur - 1 >= 0 && visited[cur - 1] == 0) {
					q.offer(cur - 1);
					visited[cur - 1] = second;
				}
				if (cur + 1 < visited.length && visited[cur + 1] == 0) {
					q.offer(cur + 1);
					visited[cur + 1] = second;
				}
				if (cur * 2 < visited.length && visited[cur * 2] == 0) {
					q.offer(cur * 2);
					visited[cur * 2] = second;
				}
			}
			size = q.size();
			list.clear();
		}
		return visited[X] - 1;
	}
}

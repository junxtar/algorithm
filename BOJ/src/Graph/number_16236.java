package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_16236 {

	static class Node {
		int x;
		int y;
		int dist;

		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int N;
	static int size = 2;
	static int eaten = 0;
	static int result = 0;
	static int row, col = 0;
	static int[][] map;
	static boolean[][] visited;

	static PriorityQueue<Node> pq = new PriorityQueue<>(
			(o1, o2) -> o1.dist != o2.dist ? Integer.compare(o1.dist, o2.dist)
					: o1.x != o2.x ? Integer.compare(o1.x, o2.x) : Integer.compare(o1.y, o2.y));

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					row = i;
					col = j;
					map[i][j] = 0;
				}
			}
		}
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		while (true) {
			visited = new boolean[N][N];
			Queue<Node> q = new LinkedList<>();
			q.offer(new Node(row, col, 0));
			visited[row][col] = true;
			while (!q.isEmpty()) {
				Node cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (nx < 0 | ny < 0 | nx >= N | ny >= N)
						continue;
					if (visited[nx][ny])
						continue;

					if (map[nx][ny] != 0 && map[nx][ny] < size) {
						q.offer(new Node(nx, ny, cur.dist + 1));
						visited[nx][ny] = true;
						pq.offer(new Node(nx, ny, cur.dist + 1));
					}

					if (map[nx][ny] == 0 || map[nx][ny] == size) {
						q.offer(new Node(nx, ny, cur.dist + 1));
						visited[nx][ny] = true;
					}
				}
			}
			if (pq.isEmpty()) {
				return;
			}
			eat();
		}
	}

	private static void eat() {
		Node cur = pq.poll();
		row = cur.x;
		col = cur.y;

		if (++eaten == size) {
			size++;
			eaten = 0;
		}
		result += cur.dist;
		map[row][col] = 0;
		pq.clear();
	}
}

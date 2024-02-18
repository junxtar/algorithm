package Level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class OilDriling {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private boolean[][] visited;
	private boolean[] frequecy;
	private int[][] map;
	private final int[] dxy = { 1, 0, -1, 0, 1 };
	private HashMap<Integer, Integer> numberMap;

	public int solution(int[][] land) {
		initialize(land);
		populateMap(land);
		return calculateResult();
	}

	private void initialize(int[][] land) {
		visited = new boolean[land.length][land[0].length];
		map = new int[land.length][land[0].length];
		numberMap = new HashMap<>();
	}

	private void populateMap(int[][] land) {
		int number = 1;
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				if (!visited[i][j] && land[i][j] == 1) {
					int value = bfs(i, j, land, number);
					numberMap.put(number, value);
					number++;
				}
			}
		}
	}

	private int bfs(int row, int column, int[][] land, int number) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, column));
		visited[row][column] = true;
		map[row][column] = number;
		int value = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			value++;
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[i].length) {
					continue;
				}
				if (!visited[nx][ny] && land[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = number;
					q.offer(new Node(nx, ny));
				}
			}
		}
		return value;
	}

	private int calculateResult() {
		int result = 0;
		for (int i = 0; i < map[0].length; i++) {
			frequecy = new boolean[numberMap.size() + 1];
			for (int j = 0; j < map.length; j++) {
				if (!frequecy[map[j][i]] && map[j][i] != 0) {
					frequecy[map[j][i]] = true;
				}
			}
			int answer = 0;
			for (int j = 0; j < frequecy.length; j++) {
				if (frequecy[j]) {
					answer += numberMap.get(j);
				}
			}
			result = Math.max(result, answer);
		}

		return result;
	}
}

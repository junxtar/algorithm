package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class UninhabitedTrip {

	// 무인도 여행
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public int[] solution(String[] maps) {
		ArrayList<Integer> list = new ArrayList<>();
		boolean flag = true;
		int[][] map = new int[maps.length][maps[0].length()];
		visited = new boolean[map.length][map[0].length];
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) != 'X') {
					map[i][j] = maps[i].charAt(j) - '0';
					flag = false;
				}
			}
		}
		
		if (flag) {
			list.add(-1);
			return list.stream().mapToInt(Integer::intValue).toArray();
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					list.add(bfs(i, j, map));
				}
			}
		}
		Collections.sort(list);
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	static int bfs(int row, int col, int[][] map) {
		int result = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col));
		result += map[row][col];
		visited[row][col] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | nx >= visited.length | ny < 0 | ny >= visited[0].length)
					continue;
				if (map[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					result += map[nx][ny];
					q.offer(new Node(nx, ny));
				}
			}
		}
		return result;
	}
}
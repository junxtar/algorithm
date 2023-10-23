package level1;

import java.util.StringTokenizer;

public class ParkWalk {
	static int[] xy = { -1, 0, 1, 0, -1 };

	public int[] solution(String[] park, String[] routes) {
		char[][] map = new char[park.length][park[0].length()];
		for (int i = 0; i < park.length; i++) {
			map[i] = park[i].toCharArray();
		}
		int row = 0;
		int col = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'S') {
					row = i;
					col = j;
				}
			}
		}

		for (int i = 0; i < routes.length; i++) {
			int[] dirArray = new int[2];
			dirArray = moveMap(row, col, routes[i], map);
			row = dirArray[0];
			col = dirArray[1];

		}
		return new int[] { row, col };
	}

	public static int[] moveMap(int row, int col, String route, char[][] map) {
		StringTokenizer st = new StringTokenizer(route);
		int dir = dirNumber(st.nextToken());
		int dis = Integer.parseInt(st.nextToken());
		int nx = row;
		int ny = col;
		for (int i = 0; i < dis; i++) {
			nx += xy[dir];
			ny += xy[dir + 1];
			if (nx < 0 | ny < 0 | nx >= map.length | ny >= map[0].length) {
				return new int[] { row, col };
			}
			if (map[nx][ny] == 'X') {
				return new int[] { row, col };
			}
		}
		return new int[] { nx, ny };
	}

	public static int dirNumber(String dir) {
		if (dir.equals("N")) {
			return 0;
		}
		if (dir.equals("E")) {
			return 1;
		}
		if (dir.equals("S")) {
			return 2;
		}
		return 3;
	}
}
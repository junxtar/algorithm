package Level2;

import java.util.LinkedList;
import java.util.Queue;

//미로 탈출 
public class MazeEscape {

	// 죄표 x, y와 횟수를 표현할 z를 클래스의 변수로 선언
	static class Node {
		int x;
		int y;
		int z;

		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	// row, col 변수 선언
	static int r = 0;
	static int c = 0;
	// 상 하 좌 우
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public int solution(String[] maps) {
		findStart(maps); // S를 찾는 메소드 static 변수 r과 c에 시작 좌표를 설정
		// S - > L 까지 가는 거리
		int lever = dfs(r, c, maps, 'L');
		// L - > E 까지 가는 거리
		int exit = dfs(r, c, maps, 'E');

		// 둘 중 하나라도 갈 수 없다면 -1 리턴
		if (lever == -1 || exit == -1)
			return -1;

		return lever + exit;
	}

	static void findStart(String[] maps) {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length(); j++) {
				if (maps[i].charAt(j) == 'S') {
					r = i;
					c = j;
				}
			}
		}
	}

	// dfs로 구현
	static int dfs(int row, int col, String[] maps, char target) {
		boolean[][] visited = new boolean[maps.length][maps[0].length()];
		Queue<Node> q = new LinkedList<>();
		visited[row][col] = true;
		q.offer(new Node(row, col, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (maps[cur.x].charAt(cur.y) == target) {
				r = cur.x;
				c = cur.y;
				return cur.z;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | ny < 0 | nx >= maps.length | ny >= maps[0].length())
					continue;
				if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
					q.offer(new Node(nx, ny, cur.z + 1));
					visited[nx][ny] = true;
				}
			}
		}
		return -1;
	}
}
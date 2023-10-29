package level1;

import java.util.LinkedList;
import java.util.Queue;

public class PressKey {
	static class Node {
		int x;
		int y;
		String hand;

		Node(int x, int y, String hand) {
			this.x = x;
			this.y = y;
			this.hand = hand;
		}
	}

	static final int ROW = 4;
	static final int COL = 3;
	static int leftRow = 3;
	static int leftCol = 0;
	static int rightRow = 3;
	static int rightCol = 2;
	static int[][] map = new int[ROW][COL];
	static int[] dxy = { -1, 0, 1, 0, -1 };
	static StringBuilder sb = new StringBuilder();

	public String solution(int[] numbers, String hand) {
		initMap();
		for (int number : numbers) {
			if (number % 3 == 0 && number != 0) {
				appendAndMoveCursor("right", number / 3 - 1, 2);
			} else if (number % 3 == 1) {
				appendAndMoveCursor("left", number / 3, 0);
			} else {
				bfs(number, hand);
			}
		}
		return sb.toString();
	}

	static void initMap() {
		for (int i = 0; i < ROW - 1; i++) {
			for (int j = 0; j < COL; j++) {
				map[i][j] = (i * 3) + (j + 1);
			}
		}
		map[3][0] = -1;
		map[3][1] = 0;
		map[3][2] = -1;
	}

	static void appendAndMoveCursor(String hand, int row, int col) {
		hand = hand.equals("right") ? "R" : "L";
		sb.append(hand);
		if (hand.equals("R")) {
			rightRow = row;
			rightCol = col;
		} else {
			leftRow = row;
			leftCol = col;
		}
	}

	static void bfs(int number, String hand) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[ROW][COL];
		visited[leftRow][leftCol] = true;
		visited[rightRow][rightCol] = true;

		if (hand.equals("right")) {
			q.offer(new Node(rightRow, rightCol, "right"));
			q.offer(new Node(leftRow, leftCol, "left"));
		} else {
			q.offer(new Node(leftRow, leftCol, "left"));
			q.offer(new Node(rightRow, rightCol, "right"));
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (map[cur.x][cur.y] == number) {
				appendAndMoveCursor(cur.hand, cur.x, cur.y);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dxy[i];
				int ny = cur.y + dxy[i + 1];

				if (nx >= 0 && nx < ROW && ny >= 0 && ny < COL && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, cur.hand));
				}
			}
		}
	}
}

package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class FillPuzzle {

	static class Node implements Comparable<Node> {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Node n) {
			if (this.x == n.x) {
				return this.y - n.y;
			}
			return this.x - n.x;
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int boardSize;
	static ArrayList<ArrayList<Node>> empty = new ArrayList<>();
	static ArrayList<ArrayList<Node>> block = new ArrayList<>();
	static boolean[][] visited;

	public int solution(int[][] game_board, int[][] table) {
		boardSize = game_board.length;
		visited = new boolean[boardSize][boardSize];

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (game_board[i][j] == 0 && !visited[i][j]) {
					empty.add(bfs(game_board, i, j, 0));
				}
			}
		}

		for (int i = 0; i < boardSize; i++) {
			Arrays.fill(visited[i], false);
		}
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (table[i][j] == 1 && !visited[i][j])
					block.add(bfs(table, i, j, 1));
			}
		}

		boolean[] visitedBoard = new boolean[empty.size()];
		int answer = 0;
		for (int i = 0; i < block.size(); i++) {
			ArrayList<Node> blockCheck = block.get(i);
			for (int j = 0; j < empty.size(); j++) {
				ArrayList<Node> emptyCheck = empty.get(j);
				if (blockCheck.size() == emptyCheck.size() && !visitedBoard[j]) {
					if (isRotate(emptyCheck, blockCheck)) {

						answer += blockCheck.size();
						visitedBoard[j] = true;
						break;
					}
				}
			}
		}
		return answer;
	}

	static ArrayList<Node> bfs(int[][] board, int row, int col, int type) {
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> result = new ArrayList<>();
		q.offer(new Node(row, col));
		visited[row][col] = true;

		result.add(new Node(0, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 | ny < 0 | nx >= boardSize | ny >= boardSize)
					continue;
				if (!visited[nx][ny] && board[nx][ny] == type) {
					q.offer(new Node(nx, ny));
					visited[nx][ny] = true;
					result.add(new Node(nx - row, ny - col));
				}
			}
		}
		Collections.sort(result);
		return result;
	}

	public static boolean isRotate(ArrayList<Node> empty, ArrayList<Node> block) {
		for (int i = 0; i < 4; i++) {
			int zeroX = block.get(0).x;
			int zeroY = block.get(0).y;

			for (int j = 0; j < block.size(); j++) {
				block.get(j).x -= zeroX;
				block.get(j).y -= zeroY;
			}
			boolean isCollect = true;

			for (int j = 0; j < empty.size(); j++) {
				Node emptyPoint = empty.get(j);
				Node blockPoint = block.get(j);

				if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
					isCollect = false;
					break;
				}
			}

			if (isCollect) {
				return true;
			} else {
				// 90도 회전 : (x, y) -> (y, -x)
				for (int j = 0; j < block.size(); j++) {
					int temp = block.get(j).x;

					block.get(j).x = block.get(j).y;
					block.get(j).y = -temp;
				}

				Collections.sort(block);
			}

		}
		return false;
	}

}

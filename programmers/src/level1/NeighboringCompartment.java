package level1;

public class NeighboringCompartment {

	public int[] dxy = { 1, 0, -1, 0, 1 };

	public int solution(String[][] board, int h, int w) {
		return searchBoard(board, h, w);
	}

	public int searchBoard(String[][] board, int h, int w) {
		String color = board[h][w];
		int answer = 0;

		for (int i = 0; i < 4; i++) {
			int nx = h + dxy[i];
			int ny = w + dxy[i + 1];

			if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
				continue;
			}
			if (board[nx][ny].equals(color)) {
				answer++;
			}

		}
		return answer;
	}
}
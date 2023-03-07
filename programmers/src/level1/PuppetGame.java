package level1;

import java.util.Stack;

public class PuppetGame {

	public int solution(int[][] board, int[] moves) {
		Stack<Integer> result = new Stack<>();
		int answer = 0;
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int value = board[j][moves[i] - 1];
				if (value == 0)
					continue;
				board[j][moves[i] - 1] = 0;
				if (!result.isEmpty()) {
					if (result.peek() == value) {
						result.pop();
						answer += 2;
						break;
					}
				}
				result.push(value);
				break;
			}
		}
		return answer;
	}
}
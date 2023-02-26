package Level2;

public class TicTacToeGame {

	public int solution(String[] board) {
		int count = 0;
		
		boolean isSuccessO = search(board, 'O');
		boolean isSuccessX = search(board, 'X');
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if (board[i].charAt(j) == 'O') {
					count++;
				}
				if (board[i].charAt(j) == 'X') {
					count--;
				}
			}
		}
		//둘다 3줄이상이면 
		if (isSuccessX && isSuccessO)
			return 0;
		//둘다 O가 3줄 완성인데 count가 1이 아니면  
		if (isSuccessO && count != 1)
			return 0;
		//둘다 X가 3줄 완성인데 count가 0이 아니면 
		if (isSuccessX && count != 0)
			return 0;
		//완성된 줄이 없는데 count가 1 또는 0이 아니면 
		if (count != 0 && count != 1)
			return 0;
		return 1;
	}

	// o의 대각선 직선 3줄이 완성이 되었는지 탐색
	static boolean search(String[] board, char ch) {
		// 행, 열 파악
		for (int i = 0; i < board.length; i++) {
			char col1 = board[i].charAt(0);
			char col2 = board[i].charAt(1);
			char col3 = board[i].charAt(2);
			if (col1 == ch && col2 == ch && col3 == ch)
				return true;
			col1 = board[0].charAt(i);
			col2 = board[1].charAt(i);
			col3 = board[2].charAt(i);
			if (col1 == ch && col2 == ch && col3 == ch)
				return true;
		}
		// 대각선 파악
		char cro1 = board[0].charAt(0);
		char cro2 = board[1].charAt(1);
		char cro3 = board[2].charAt(2);
		if (cro1 == ch && cro2 == ch && cro3 == ch)
			return true;
		cro1 = board[2].charAt(0);
		cro3 = board[0].charAt(2);
		if (cro1 == ch && cro2 == ch && cro3 == ch)
			return true;

		return false;
	}
}
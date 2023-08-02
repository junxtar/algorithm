package Level2;

public class QuadCompression {

	static int zero = 0;
	static int one = 0;

	public int[] solution(int[][] arr) {
		divide(0, 0, arr.length, arr);
		return new int[] { zero, one };

	}

	static void divide(int row, int col, int n, int[][] arr) {
		int flag = arr[row][col];
		boolean isDifferent = false;
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (flag != arr[i][j]) {
					isDifferent = true;
				}
			}
		}
		if (!isDifferent) {
			if (flag == 0) {
				zero++;
			} else {
				one++;
			}
			return;
		}
		divide(row, col, n / 2, arr); // 0, 0, 4
		divide(row + (n / 2), col, n / 2, arr); // 4, 0, 4
		divide(row, col + (n / 2), n / 2, arr); // 0, 4, 4
		divide(row + (n / 2), col + (n / 2), n / 2, arr); // 4, 4, 4
	}

}

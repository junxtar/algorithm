package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1780 {

	static int N;
	static int[][] map;

	static int result1 = 0;
	static int result2 = 0;
	static int result3 = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, N);
		sb.append(result1).append("\n").append(result2).append("\n").append(result3);

		System.out.println(sb.toString());
	}

	static void divide(int row, int col, int n) {
		boolean isDifferent = false;
		int flag = map[row][col];
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (flag != map[i][j]) {
					isDifferent = true;
				}
			}
		}
		if (!isDifferent) {
			if (flag == -1) {
				result1++;
			} else if (flag == 0) {
				result2++;
			} else {
				result3++;
			}
			return;
		}
		int newSize = n /3 ;
		divide(row, col, newSize); // 0 0 3
		divide(row, col + newSize, newSize); // 0 3 3
		divide(row, col + newSize * 2, newSize); // 0 6 3
		
		divide(row + newSize, col, newSize); // 3 0 3
		divide(row + newSize, col + newSize, newSize); // 3 3 3
		divide(row + newSize, col + newSize * 2, newSize); // 3 6 3
		
		divide(row + newSize * 2, col, newSize); // 6 0 3
		divide(row + newSize * 2, col + newSize, newSize); // 6 3 3
		divide(row + newSize * 2, col + newSize * 2, newSize); // 6 6 3
	
	}
}

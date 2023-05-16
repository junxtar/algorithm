package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_1992 {

	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		divide(0, 0, N);
		System.out.println(sb.toString());
	}
	static void divide(int row, int col, int n) {
		int cnt = 0;
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				cnt += map[i][j];
			}
		}
		if (cnt == n * n) {
			sb.append(1);
			return;
		}
		if (cnt == 0) {
			sb.append(0);
			return;
		}
		sb.append("(");
		divide(row, col, n / 2);
		divide(row, col + (n / 2), n / 2);
		divide(row + (n / 2), col, n / 2);
		divide(row + (n / 2), col + (n / 2), n / 2);
		sb.append(")");
	}
}

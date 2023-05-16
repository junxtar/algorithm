package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2630 {

	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, N);
		sb.append(white).append("\n").append(blue);
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
			blue++;
			return;
		}
		if (cnt == 0) {
			white++;
			return;
		}
		divide(row, col, n / 2); // 0, 0, 4
		divide(row + (n / 2), col, n / 2); // 4, 0, 4
		divide(row, col + (n / 2), n / 2); // 0, 4, 4
		divide(row + (n / 2), col + (n / 2), n / 2); //4, 4, 4
	}
}

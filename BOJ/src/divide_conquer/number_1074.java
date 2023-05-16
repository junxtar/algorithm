package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1074 {

	static int N, r, c;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		N = (int) Math.pow(2, N);
		divide(r, c, N);
	}

	static void divide(int row, int col, int size) {
		if (size == 1) {
			System.out.println(cnt);
			return;
		}
		
		int n = size / 2;
		if (row < n && col < n) {
			cnt += n * n * 0;
			divide(row, col, n);
		} else if (row < n && col < n + n) {
			cnt += n * n * 1;
			divide(row, col - n, n);
		} else if (row < n + n && col < n) {
			cnt += n * n * 2;
			divide(row - n, col, n);
		} else if (row < n + n && col < n + n){
			cnt += n * n * 3;
			divide(row - n, col - n, n);
		}
	}
}

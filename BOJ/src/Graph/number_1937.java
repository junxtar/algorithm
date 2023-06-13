package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1937 {
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dxy = { 1, 0, -1, 0, 1 };
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = Math.max(result, dfs(i, j));
			}
		}
		System.out.println(result);

	}

	static int dfs(int row, int col) {
		if (dp[row][col] != 0) {
			return dp[row][col];
		}
		dp[row][col] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = row + dxy[i];
			int ny = col + dxy[i + 1];

			if (nx < 0 | ny < 0 | nx >= N | ny >= N)
				continue;
			if (map[nx][ny] <= map[row][col])
				continue;
			dp[row][col] = Math.max(dp[row][col], dfs(nx, ny) + 1);
			dfs(nx, ny);
		}
		return dp[row][col];
	}

}

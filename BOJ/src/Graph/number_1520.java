package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1520 {

	static int N;
	static int M;
	static int[][] map;
	static int[][]dp;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
	}
	static int dfs(int row, int column) {
		if(row == N-1 && column == M-1) {
			return 1;
		}
		if(dp[row][column]!=-1) {
			return dp[row][column];
		}
		dp[row][column] = 0;
		for(int i = 0; i<4; i++) {
			int nx = row+dx[i];
			int ny = column+dy[i];
			if(nx < 0 | nx >= N | ny < 0 | ny >= M)	continue;
			if(map[row][column] > map[nx][ny]) {
				dp[row][column] += dfs(nx,ny);
			}
		}
		return dp[row][column];
	}

}

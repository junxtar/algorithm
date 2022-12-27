package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1987 {

	static int R;
	static int C;
	static int count = Integer.MIN_VALUE;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(dfs(0,0,0));
		
	}

	static int dfs(int row, int column, int depth) {
		if(depth > count) {
			count = depth;
		}
		visited[map[row][column] - 65] = true;
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = column + dy[i];
			if (nx < 0 | nx >= R | ny < 0 | ny >= C)
				continue;
			if (!visited[map[nx][ny] - 65]) {
				visited[map[nx][ny] - 65] = true;
				dfs(nx, ny, depth+1);
				visited[map[nx][ny]- 65]= false;
			}
		}
		return count+1;
	}
}

package Level2;

public class TriangularSnail {
	
	static int[] dx = { 1, 0, -1 };
	static int[] dy = { 0, 1, -1 };

	public int[] solution(int n) {
		int dir = 0;
		int cx = 0;
		int cy = 0;
		
		int[][] map = new int[n][n];
		int[] answer = new int[(n * (n + 1)) / 2];
		
		map[cx][cy] = 1;
		
		for (int i = 2; i <= (n * (n + 1)) / 2; i++) {
			int nx = cx + dx[dir % 3];
			int ny = cy + dy[dir % 3];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0) {
				dir += 1;
				i--;
				continue;
			}
			map[nx][ny] = i;
			cx = nx;
			cy = ny;
		}
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[idx] = map[i][j];
				idx++;
			}
		}
		return answer;
	}
}
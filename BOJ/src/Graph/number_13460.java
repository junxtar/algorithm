package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_13460 {

	static class Node {
		int redX;
		int redY;
		int blueX;
		int blueY;
		int z;

		Node(int redX, int redY, int blueX, int blueY, int z) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.z = z;
		}
	}

	static int N, M;
	static int redX, redY, blueX, blueY;
	static char[][] map;
	static boolean[][][][] visited;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'R') {
					redX = i;
					redY = j;
				}
				if (map[i][j] == 'B') {
					blueX = i;
					blueY = j;
				}
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(redX, redY, blueX, blueY, 1));
		visited[redX][redY][blueX][blueY] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.z > 10) {
				return -1;
			}

			for (int i = 0; i < 4; i++) {
				int rnx = cur.redX;
				int rny = cur.redY;

				int bnx = cur.blueX; 
				int bny = cur.blueY;
				
				boolean redHole = false;
				boolean blueHole = false;
				
				while (map[rnx+ dx[i]][rny + dy[i]] != '#') {
					rnx += dx[i];
					rny += dy[i];
					if (map[rnx][rny] == 'O') {
						redHole = true;
						break;
					}
				}
				
				while (map[bnx+ dx[i]][bny + dy[i]] != '#') {
					bnx += dx[i];
					bny += dy[i];
					if (map[bnx][bny] == 'O') {
						blueHole = true;
						break;
					}
				}
				if (blueHole) {
					continue;
				}
				if (redHole && !blueHole) {
					return cur.z;
				}
				if (rnx == bnx && rny == bny) {
					if (i == 0) {
						if (cur.redX > cur.blueX) {
							rnx -= dx[i];
						} else {
							bnx -= dx[i];
						}
					} else if (i == 1) {
						if (cur.redY < cur.blueY) {
							rny -= dy[i]; 
						} else {
							bny -= dy[i];
						}
					} else if (i == 2) {
						if (cur.redX < cur.blueX) {
							rnx -= dx[i];
						} else {
							bnx -= dx[i];
						}
					} else if (i == 3){
						if (cur.redY > cur.blueY) {
							rny -= dy[i];
						} else {
							bny -= dy[i];
						}
					}
				}
				if (!visited[rnx][rny][bnx][bny]) {
					visited[rnx][rny][bnx][bny] = true;
					q.offer(new Node(rnx, rny, bnx, bny, cur.z + 1));
				}
			}
		}
		return -1;
	}
}

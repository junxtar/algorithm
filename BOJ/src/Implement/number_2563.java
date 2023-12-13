package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2563 {

	private static final int X = 101;
	private static final int Y = 101;
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] visited = new boolean[X][Y];
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			for (int i = row; i < row + WIDTH; i++) {
				for (int j = col; j < col + HEIGHT; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						answer++;
					}
				}
			}
			
		}
		System.out.println(answer);
	}
}

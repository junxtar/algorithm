package Cumulaative_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_11660 {
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
	
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j = 1; j <= N; j++) {
				sum += Integer.parseInt(st.nextToken());
				map[i][j] = sum;
			}
		}
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(partSum(x1,y1,x2,y2)).append("\n");
		}
		System.out.println(sb);
	}
	static int partSum(int x1, int y1, int x2, int y2) {
		int result = 0;
		for(int i = x1; i<=x2; i++) {
			result += (map[i][y2] - map[i][y1-1]);
		}
		return result;
	   
		
	}

}

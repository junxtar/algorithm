package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_1058 {
	
	static int N;
	static int count;
	static char[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i<N; i++) {
			count = 0;
			visited = new boolean[N];
			arr[i] = dfs(i) - 1;
		}
		for(int data:arr) {
			System.out.println(data);
		}
	}
	static int dfs(int n) {
		if(!visited[n]) {
			visited[n] = true;
			count++;
		}
		for(int i = 0; i<N; i++) {	
			if(!visited[i] && map[n][i]=='Y') {
				dfs(i);
				}
			}
		return count;
	}
	

}

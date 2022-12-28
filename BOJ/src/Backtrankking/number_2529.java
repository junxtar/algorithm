package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2529 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[] sign;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sign = new char[N];
		arr = new int[N + 1];
		
		int[] front = new int[10];
		int[] back = new int[10];
		for (int i = 0; i < 10; i++) {
			front[i] = i;
			back[9 - i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		dfs(back,0, new boolean[10]);
		dfs(front,0, new boolean[10]);
		
		System.out.println(sb);
	}

	static boolean dfs(int[]dir, int depth, boolean[] visited) {
		if (depth == N + 1) {
			for (int data : arr) {
				sb.append(data);	
			}
			sb.append("\n");
			return true;
			
		}
		for (int idx = 0; idx <= N; idx++) {
			int i = dir[idx];
			if (visited[idx])
				continue;
			if(depth == 0 || check(arr[depth-1],sign[depth-1],i)) {
				visited[idx] = true;
				arr[depth] = i;
				if (dfs(dir, depth + 1, visited)) return true;
				visited[idx] = false;
	
			}
		}
		
		return false;
	}
	static boolean check(int a, char sign, int b) {
		if (sign == '<')
			return a < b;
		else
			return a > b;
	}
}

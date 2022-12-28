package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_15655 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[]arr;
	static int[]temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		temp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(temp);
		dfs(0,0);
		System.out.println(sb);
		
	}
	static void dfs(int at, int depth) {
		if(depth == M) {
			for(int data: arr) {
				sb.append(data+" ");
			}sb.append("\n");
			return;
		}
		for(int i = at; i<N; i++) {
			arr[depth] = temp[i];
			dfs(i+1,depth+1);
		}
	}

}

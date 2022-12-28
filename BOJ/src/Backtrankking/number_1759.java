package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_1759 {

	static int L;
	static int C;
	static char[] arr, data;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[C];
		arr = new char[L];
		visited = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			data[i] = st.nextToken().charAt(0);
		}
			Arrays.sort(data);
			dfs(0, 0);
			System.out.println(sb);
	}

	static void dfs(int at, int depth) {
		int vowels = 0;
		int consonants = 0;
		if (depth == L) {
			for (char ch : arr) {
				if (ch == 'a' | ch == 'e' | ch == 'i' | ch == 'o' | ch == 'u') {
					vowels++;
				}else {
					consonants++;
				}
			}
			if (vowels > 0 && consonants > 1) {
				for (char ch : arr) {
					sb.append(ch);
				}
				sb.append("\n");
				return;
			}return;
		}
		for (int i = at; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = data[i];
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
}

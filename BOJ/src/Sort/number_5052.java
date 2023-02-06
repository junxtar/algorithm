package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class number_5052 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			String[]phone_book = new String[n];
			for(int i = 0; i<n; i++) {
				phone_book[i] = br.readLine();
			}
			sb.append(solution(phone_book)).append("\n");
		}
		System.out.println(sb);
	}

	public static String solution(String[] phone_book) {
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			String str = phone_book[i];
			if (phone_book[i + 1].startsWith(str)) {
				return "NO";
			}
		}
		return "YES";
	}
}

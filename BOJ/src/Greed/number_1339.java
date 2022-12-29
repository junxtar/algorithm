package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class number_1339 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer[]ch = new Integer[26];
		Arrays.fill(ch, 0);
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				ch[str.charAt(j) - 65] += (int)Math.pow(10, str.length()-1-j);
			}
		}
		Arrays.sort(ch,Collections.reverseOrder());
		
		int result = 0;
		int flag = 9;
		for(int i = 0; i<10; i++) {
			result += ch[i] *flag;
			flag--;
		}
		System.out.println(result);
	}
}

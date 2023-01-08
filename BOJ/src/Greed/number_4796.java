package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_4796 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int count = 0;
		while(!str.equals("0 0 0")) {
			count++;
			StringTokenizer st = new StringTokenizer(str);
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int result = ((V / P) * L);
			
			result = ((V % P)) < L ? result + (V % P) : result + L;
			
			sb.append("Case "+count+": ").append(result).append("\n");
			str = br.readLine();
		}
		System.out.println(sb);
	}
}

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1011 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int distance = y - x;

			int max = (int) Math.sqrt(distance);

			if (max == Math.sqrt(distance)) {
				sb.append(max * 2 - 1).append("\n");
			} else if (distance <= max * max + max) {
				sb.append(max * 2).append("\n");
			} else {
				sb.append(max * 2 + 1).append("\n");
			}

		}
		System.out.println(sb);

	}

}

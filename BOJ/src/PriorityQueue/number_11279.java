package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class number_11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				sb.append(q.size() == 0 ? 0 : q.poll()).append("\n");
			} else {
				q.add(x);
			}
		}
		System.out.println(sb);

	}

}

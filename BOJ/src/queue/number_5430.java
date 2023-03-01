package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class number_5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			Deque<Integer> deque = new LinkedList<>();
			int count_r = 0;
			int count_d = 0;
			boolean temp = true;
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			for (int i = 0; i < n; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < command.length(); i++) {

				if (command.charAt(i) == 'D')
					count_d++;
				else
					count_r++;
			}
			if (count_d < deque.size()) {

				for (int i = 0; i < command.length(); i++) {
					if (command.charAt(i) == 'D' && temp) {
						deque.poll();
					} else if (!temp && command.charAt(i) == 'D') {
						deque.pollLast();
					} else if (!temp && command.charAt(i) == 'R') {
						temp = true;
					} else
						temp = false;
				}

				sb.append("[");
				if (count_r % 2 == 0) {
					for (int i = 0; i < n - count_d - 1; i++) {
						sb.append(deque.poll() + ",");
					}
					sb.append(deque.poll() + "]\n");
				} else {
					for (int i = 0; i < n - count_d - 1; i++) {
						sb.append(deque.pollLast() + ",");
					}
					sb.append(deque.poll() + "]\n");
				}

			} else if (deque.size() == count_d) {
				sb.append("[]").append("\n");
			} else {
				sb.append("error").append("\n");

			}

		}

		System.out.println(sb);

	}
}

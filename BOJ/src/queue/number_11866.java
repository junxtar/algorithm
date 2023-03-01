package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_11866 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		if (sb.length()==0) {
			sb.append("<");
		}

		while (!queue.isEmpty()) {
			count++;
			if (queue.size() == 1) {
				sb.append(queue.poll());
				break;
			}
			if (count % K == 0) {
				sb.append(queue.poll() + ", ");
			} else {
				int n = queue.poll();
				queue.offer(n);
			}
		}
		sb.append(">");

		System.out.println(sb);
	}

}

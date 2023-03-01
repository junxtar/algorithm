package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class number_1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 문서의 개수
			int n = Integer.parseInt(st.nextToken());
			// 찾고자 하는 문서 인덱스
			int m = Integer.parseInt(st.nextToken());
			LinkedList<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			int answer = 0;
			for (int i = 0; i < n; i++) {
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
			while (!q.isEmpty()) {
				int[] front = q.poll();
				boolean temp = true;

				for (int i = 0; i < q.size(); i++) {
					if (front[1] < q.get(i)[1]) {
						q.offer(front);

						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						temp = false;
						break;
					}
				}
				if (!temp) {
					continue;
				}
				answer++;
				if (front[0] == m) {

					break;
				}
			}
			sb.append(answer).append("\n");

		}
		System.out.println(sb);
	}

}

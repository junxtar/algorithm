package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class number_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int count = 0;

		while (!list.isEmpty()) {
			int index = 0;
			for (Integer data : deque) {
				if (list.get(0) == data)
					break;
				index++;
			}

			if ((deque.size() / 2) >= index) {
				while (true) {
					int num_front = deque.pollFirst();
					if (num_front == list.get(0))
						break;

					deque.offer(num_front);
					count++;

				}

			} else {
				while (true) {
					int num_back = deque.pollLast();
					if (num_back == list.get(0)) {
						count++;
						break;
					}
					deque.offerFirst(num_back);
					count++;

				}

			}
			list.remove(0);

		}
		System.out.println(count);

	}

}

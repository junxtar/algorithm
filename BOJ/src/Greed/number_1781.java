package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1781 {

	static class Assignment {
		int day;
		int value;

		public Assignment(int day, int value) {
			this.day = day;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int answer = 0;
		ArrayList<Assignment> list = new ArrayList<>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list.add(new Assignment(day, value));
		}
		Collections.sort(list, new Comparator<Assignment>() {

			@Override
			public int compare(Assignment o1, Assignment o2) {
				return o1.day - o2.day;
			}

		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Assignment data : list) {
			int value = data.value;
			int day = data.day;

			if (pq.size() >= day) {
				if (pq.peek() < value) {
					pq.poll();
					pq.offer(value);
				}
				continue;
			}
			pq.offer(value);
		}
		for (int value : pq) {
			answer += value;
		}
		System.out.println(answer);
	}
}

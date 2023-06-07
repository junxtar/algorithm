package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_2109 {

	static class Information {
		int value;
		int day;

		public Information(int value, int day) {
			this.value = value;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Information> list = new ArrayList<>();
		int answer = 0;
		StringTokenizer st;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			list.add(new Information(value, day));
		}
		Collections.sort(list, new Comparator<Information>() {

			@Override
			public int compare(Information o1, Information o2) {
				if (o1.day == o2.day)
					return o2.value - o1.value;
				return o1.day - o2.day;
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Information data : list) {
			int value = data.value;
			int day = data.day;

			if (day <= pq.size()) {
				if (value > pq.peek()) {
					pq.poll();
					pq.offer(value);
				}
				continue;
			}
			pq.offer(value);
		}
		while (!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}
}

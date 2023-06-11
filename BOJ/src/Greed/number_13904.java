package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_13904 {

	static class Assignment {
		int day;
		int score;

		Assignment(int day, int score) {
			this.day = day;
			this.score = score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Assignment> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		StringTokenizer st;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			list.add(new Assignment(day, score));
		}
		Collections.sort(list, new Comparator<Assignment>() {

			@Override
			public int compare(Assignment o1, Assignment o2) {
				if (o1.day == o2.day)
					return o2.score - o1.score;
				return o1.day - o2.day;
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (Assignment data : list) {

			int day = data.day;
			int score = data.score;
			
			if (pq.size() < day) {
				pq.offer(score);
				answer += score;
				continue;
			}
			if (score > pq.peek()) {
				answer -= pq.poll();
				answer += score;
				pq.offer(score);
			}

		}
		System.out.println(answer);
	}
}

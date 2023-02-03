package Level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HotelRoom {

	// 문자열 시간을 숫자로 반환해서 담을 배열 선언
	static int[][] time;

	public int solution(String[][] book_time) {
		int answer = 0;
		time = new int[book_time.length][2];
		// 문자열 시간 숫자로 변환
		for (int i = 0; i < book_time.length; i++) {
			String start = book_time[i][0];
			String end = book_time[i][1];
			transTime(start, end, i);
		}
		// 입실 시간을 기준으로 오름차순 정렬
		Arrays.sort(time, new Comparator<int[]>() {
			// @override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		// 퇴실 시간을 오름차순 우선순위 큐 선언
		PriorityQueue<int[]> use = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		for (int i = 0; i < time.length; i++) {
			while (!use.isEmpty() && use.peek()[1] <= time[i][0]) {
				use.poll();
			}
			use.add(time[i]);
			answer = Math.max(answer, use.size());
		}
		return answer;
	}

	static void transTime(String start, String end, int index) {

		String hour = start.substring(0, 2);
		String min = start.substring(3, 5);

		time[index][0] = (Integer.parseInt(hour) * 60) + Integer.parseInt(min);

		hour = end.substring(0, 2);
		min = end.substring(3, 5);

		time[index][1] = (Integer.parseInt(hour) * 60) + Integer.parseInt(min) + 10;
	}
}
package Level3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoublePriorityQueue {

	// 최댓값과 최솟값 구분을 위한 오름차순, 내림차순 PriorityQueue구현
	static PriorityQueue<Integer> asc = new PriorityQueue<>();
	static PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());

	public int[] solution(String[] operations) {
		// 문자열 가르기 위한 StringTokenizer 클래스 사용
		StringTokenizer st;

		for (int i = 0; i < operations.length; i++) {

			st = new StringTokenizer(operations[i]);

			String command = st.nextToken();
			int value = Integer.parseInt(st.nextToken());

			method(command, value);
		}
		// 우선순위 큐가 비었다면 0,0 리턴
		if (desc.isEmpty()) {
			return new int[] { 0, 0 };
		}
		// 우선순위 큐 size가 1이면 최댓값에 poll해주고 최솟값은 0으로 return
		if (desc.size() == 1) {
			return new int[] { desc.poll(), 0 };
		}
		// 내림차순 poll, 오름차순 poll return
		return new int[] { desc.poll(), asc.poll() };
	}

	static void method(String command, int value) {
		// command가 I인 경우 두개의 우선순위 큐에 추가
		if (command.equals("I")) {
			asc.offer(value);
			desc.offer(value);
			return;
		}
		if (asc.isEmpty() && desc.isEmpty())
			return;
		// command가 D인 경우 -1인지 1인지에 따라 구현 방법이 다름
		if (value == 1) {
			// 1인 경우 desc에 가장 앞에 value를 poll하면서 그 값을 asc에 remove
			asc.remove(desc.poll());
		} else {
			// -1인 경우 asc에 가장 앞에 value를 poll하면서 그 값을 desc에 remove
			desc.remove(asc.poll());
		}
	}
}

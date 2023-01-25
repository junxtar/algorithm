package Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {
	public int[] solution(int[] progresses, int[] speeds) {
		// 큐 배열에는 각 기능들이 남은 기간을 담는다.
		Queue<Integer> q = new LinkedList<>();
		// 리스트는 각 배포마다 몇개의 기능이 배포되는지 정답을 담는다.
		ArrayList<Integer> list = new ArrayList<>();

		// 각 기능의 남은 기간을 구해준다.
		for (int i = 0; i < speeds.length; i++) {
			int leavings = 100 - progresses[i];
			if (leavings % speeds[i] == 0) {
				q.offer(leavings / speeds[i]);
				continue;
			}
			q.offer(leavings / speeds[i] + 1);
		}
		int count = 1;
		int cv = q.poll();
		while (!q.isEmpty()) {
			int nv = q.poll();
			if (cv >= nv) {
				count++;
				continue;
			}
			list.add(count);
			count = 1;
			cv = nv;
		}
		list.add(count);
		// stream을 이용하여 리스트를 정수형 배열로 변환
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
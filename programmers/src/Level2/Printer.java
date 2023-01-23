package Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	int index;
	int priority;

	Printer(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}

	public int solution(int[] priorities, int location) {
		Queue<Printer> q = new LinkedList<>();
		int answer = 0;
		for (int i = 0; i < priorities.length; i++) {
			q.offer(new Printer(i, priorities[i]));
		}
		int index = priorities.length - 1;
		Arrays.sort(priorities);
		while (!q.isEmpty()) {
			Printer p = q.poll();
			if (p.priority != priorities[index]) {
				q.offer(new Printer(p.index, p.priority));
			} else {
				index--;
				answer++;
				if (p.index == location) {
					return answer;
				}
			}
		}
		return answer;
	}
}
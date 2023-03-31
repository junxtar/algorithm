package Level2;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.ArrayList;

public class ProceedingAssignment {

	static class Subject {
		String name;
		int restTime;

		public Subject(String name, int restTime) {
			this.name = name;
			this.restTime = restTime;
		}
	}

	static ArrayList<String> list = new ArrayList<>();

	public String[] solution(String[][] plans) {

		Stack<Subject> stack = new Stack<>();
		transformArray(plans);

		Arrays.sort(plans, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {

				return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
			}
		});

		for (int i = 0; i < plans.length - 1; i++) {
			int curTime = Integer.parseInt(plans[i][1]);
			int nextTime = Integer.parseInt(plans[i + 1][1]);
			int playTime = Integer.parseInt(plans[i][2]);

			if (nextTime - curTime < playTime) {
				stack.push(new Subject(plans[i][0], playTime - (nextTime - curTime)));
				continue;
			}
			list.add(plans[i][0]);
			if (nextTime - curTime > playTime) {
				int rest = (nextTime - curTime) - playTime;
				while (stack.isEmpty() && rest > 0) {
					Subject s = stack.pop();
					rest -= s.restTime;
					if (rest >= 0) {
						list.add(s.name);
					} else {
						stack.push(new Subject(s.name, Math.abs(rest)));
					}
				}
			}
		}
		remain(plans, stack);

		return list.toArray(new String[list.size()]);
	}

	static void transformArray(String[][] plans) {
		for (int i = 0; i < plans.length; i++) {
			StringTokenizer st = new StringTokenizer(plans[i][1], ":");
			int hour = Integer.parseInt(st.nextToken()) * 60;
			int min = Integer.parseInt(st.nextToken());
			int result = hour + min;
			plans[i][1] = Integer.toString(result);
		}
	}

	static void remain(String[][] plans, Stack<Subject> stack) {
		list.add(plans[plans.length - 1][0]);

		while (!stack.isEmpty()) {
			String name = stack.pop().name;
			list.add(name);
		}

	}
}
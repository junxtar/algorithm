package level1;

import java.util.Stack;

public class HateSameNumber {
	public int[] solution(int[] arr) {
		Stack<Integer> s = new Stack<>();
		s.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if (s.peek() == arr[i]) {
				continue;
			}
			s.push(arr[i]);
		}

		return s.stream().mapToInt(Integer::intValue).toArray();
	}
}

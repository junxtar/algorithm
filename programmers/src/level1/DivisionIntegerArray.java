package level1;

import java.util.ArrayList;
import java.util.Collections;

public class DivisionIntegerArray {
	public int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int value : arr) {
			if (value % divisor == 0) {
				list.add(value);
			}
		}
		if (list.size() == 0) {
			return new int[] { -1 };
		}
		Collections.sort(list);

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}

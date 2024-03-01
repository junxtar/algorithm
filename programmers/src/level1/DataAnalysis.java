package level1;

import java.util.ArrayList;
import java.util.Collections;

public class DataAnalysis {

	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		int[][] answer;
		ArrayList<int[]> list = new ArrayList<>();

		for (int[] arr : data)
			if (arr[setCategory(ext)] < val_ext)
				list.add(arr);

		Collections.sort(list, (o1, o2) -> {
			return o1[setCategory(sort_by)] - o2[setCategory(sort_by)];
		});

		answer = new int[list.size()][];

		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);

		return answer;
	}

	public int setCategory(String category) {
		if (category.equals("code")) {
			return 0;
		}
		if (category.equals("date")) {
			return 1;
		}
		if (category.equals("maximum")) {
			return 2;
		}
		return 3;
	}
}

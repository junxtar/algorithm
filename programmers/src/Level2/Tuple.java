package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tuple {

	public int[] solution(String s) {
		List<List<Integer>> list = parseInput(s);
		list.sort((o1, o2) -> o1.size() - o2.size());
		return extractUniqueNumbers(list);
	}

	private List<List<Integer>> parseInput(String s) {
		List<List<Integer>> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(s, "{}");
		while (st.hasMoreTokens()) {
			String element = st.nextToken();
			if (element.equals(",")) {
				continue;
			}
			list.add(parseElement(element));
		}
		return list;
	}

	private List<Integer> parseElement(String element) {
		List<Integer> sublist = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(element, ",");
		while (st.hasMoreTokens()) {
			int value = Integer.parseInt(st.nextToken());
			sublist.add(value);
		}
		return sublist;
	}

	private int[] extractUniqueNumbers(List<List<Integer>> list) {
		boolean[] visited = new boolean[100001];
		int index = 0;
		int[] answer = new int[list.size()];
		for (List<Integer> subList : list) {
			for (Integer value : subList) {
				if (!visited[value]) {
					visited[value] = true;
					answer[index++] = value;
				}
			}
		}
		return answer;
	}
}
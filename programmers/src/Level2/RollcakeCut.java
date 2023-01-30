package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class RollcakeCut {
	// 롤케이크 자르기
	public int solution(int[] topping) {
		// Set과 Map을 이용한 풀이
		HashSet<Integer> A = new HashSet<>();
		HashMap<Integer, Integer> B = new HashMap<>();

		int answer = 0;
		// set에 첫번째 토핑을 담고 남은 토핑들은 빈도수 체크를 위한 map에 담는다
		A.add(topping[0]);
		for (int i = 1; i < topping.length; i++) {
			B.put(topping[i], B.getOrDefault(topping[i], 0) + 1);
		}
		// 다시 반복하면서 A에는 토핑을 추가하고 B에는 토핑들을 하나씩 빼면서 결과값을 구해준다
		for (int i = 1; i < topping.length; i++) {
			A.add(topping[i]);
			B.put(topping[i], B.get(topping[i]) - 1);
			if (B.get(topping[i]) == 0)
				B.remove(topping[i]);
			if (A.size() == B.size())
				answer++;
		}

		return answer;
	}
}
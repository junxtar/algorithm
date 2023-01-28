package Level2;

import java.util.Stack;

public class CourierBox {
	// 택배상자
	public int solution(int[] order) {
		// Stack를 이용한 풀이
		Stack<Integer> s = new Stack<>();
		// value 초기값을 첫번째로 밀어넣어야 하는 상자 번호로 초기화
		int value = order[0];
		int answer = 0;
		// 1부터 value까지 Stack에 값 넣기
		for (int i = 1; i < value; i++) {
			s.push(i);
		}
		// 첫번째 상자를 트럭에 실었으므로 answer++, value++
		value++;
		answer++;

		// 다음 실어야 하는 상자 번호와 value값을 비교
		for (int i = 1; i < order.length; i++) {
			// 값이 같으면 value++;
			if (value == order[i]) {
				value++;
				// value 값이 크다면 실어야 하는 상자 번호는 컨테이너에 있다는 의미
			} else if (value > order[i]) {
				// 컨테이너에 맨 앞에 상자 번호가 다르면 반복문 탈출
				if (order[i] != s.pop()) {
					break;
				}
				// value 값이 작다면 반복문을 돌려서
				// value 값부터 다음 실어야 하는 상자 번호까지 stack에 추가
			} else {
				for (int j = value; j < order[i]; j++) {
					s.push(j);
				}
				// value값은 실은 상자번호 + 1로 초기화
				value = order[i] + 1;
			}
			// 세개의 조건 과정 모두 한번은 실었으므로 answer++
			answer++;
		}
		return answer;
	}
}
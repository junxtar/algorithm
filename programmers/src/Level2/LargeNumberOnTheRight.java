package Level2;

import java.util.Collections;
import java.util.Stack;

public class LargeNumberOnTheRight {
	// 뒤에 있는 큰 수 찾기 
	public int[] solution(int[] numbers) {
		// 결과 값을 담은 result와 값을 저장할 store변수를 stack으로 선언
		Stack<Integer> result = new Stack<>();
		Stack<Integer> store = new Stack<>();
		// 마지막 인덱스는 무조건 -1이므로 결과 stack에 -1 push
		result.push(-1);
		// 마지막 value 저장소 stack에 value push
		store.push(numbers[numbers.length - 1]);
		// 마지막 전에 인데스 부터 첫번째 인덱스까지 반복
		for (int i = numbers.length - 2; i >= 0; i--) {
			int target = numbers[i];
			// 저장소가 비어 있지 않을 때 반복
			while (!store.isEmpty()) {
				// 만약에 저장소에 마지막 data가 target보다 크면 break;
				if (store.peek() > target) {
					break;
				}
				// 크지 않다면 저장소 data를 pop
				store.pop();
			}
			// 만약 저장소가 비었다면
			if (store.isEmpty()) {
				// 뒤에 큰 수가 없다는 뜻이므로 결과 stack에 -1 추가
				result.push(-1);
			} else {
				// 만약 비어있지 않다면 뒤에 큰 수가 있다는 뜻이므로
				// 결과 값에 저장소에 마지막 data를 push
				result.push(store.peek());
			}
			// 저장소에 target을 추가
			store.push(target);
		}
		// stack을 array로 변환할때 값이 선입 선출 방법으로 나오기 때문에 reverse() 메서드 사용
		Collections.reverse(result);
		// stack을 array로 변환
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}
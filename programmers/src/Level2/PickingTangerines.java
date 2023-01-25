package Level2;

import java.util.Arrays;
import java.util.Collections;
//귤 고르기
public class PickingTangerines {
	public int solution(int k, int[] tangerine) {
		// Integer 배열로 선언한 이유는 Collections 클래스를 사용하기 위해서
		Integer[] arr = new Integer[100000001];
		// Integer 배열은 기본값이 null이기 때문에 0으로 배열 초기화
		Arrays.fill(arr, 0);
		// 빈도수를 측정
		// 원소값이 1 1 1 2 3 이라고 가정하면
		// Integer배열은
		// [0, 3, 1, 1, .........]
		// 내림차순 정렬 -> [3, 1, 1, 0........]
		for (int i = 0; i < tangerine.length; i++) {
			arr[tangerine[i]]++;
		}
		Arrays.sort(arr, Collections.reverseOrder());
		int answer = 0;
		// 배열을 돌면서 k값이 0이하가 될때까지 answer 1씩 증가
		for (int i = 0; i < arr.length; i++) {
			k -= arr[i];
			answer++;
			if (k <= 0) {
				return answer;
			}
		}
		return answer;
	}
}
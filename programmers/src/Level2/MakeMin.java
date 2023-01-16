package Level2;

import java.util.Arrays;

public class MakeMin {
	
	public int solution(int[] A, int[] B) {
		
		int answer = 0;
		//두 배열을 모두 정렬한 뒤 각각의 자릿수를 곱해줍니다. 
		Arrays.sort(A);
		Arrays.sort(B);
		
		//인덱스의 위치가 달라야하기 때문에 하나의 배열은 정방향으로
		//다른 하나의 배열은 역방향을 답을 구현하였습니다.
		
		for (int i = 0; i < A.length; i++) {
			answer += (A[i] * B[B.length - i - 1]);
		}
		return answer;
	}
}

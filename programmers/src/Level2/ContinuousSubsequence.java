package Level2;

import java.util.HashSet;

//연속 부분 수열합의 개수 
public class ContinuousSubsequence {
	public int solution(int[] elements) {

		HashSet<Integer> result = new HashSet<>();
		int[] arr = new int[elements.length * 2];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = elements[i % elements.length];
		}

		for (int i = 0; i < elements.length; i++) {
			int value = 0;
			for (int j = i; j < elements.length + i; j++) {
				value += arr[j];
				result.add(value);
			}
		}
		return result.size();
	}
}
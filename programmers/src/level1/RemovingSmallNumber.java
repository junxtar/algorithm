package level1;

public class RemovingSmallNumber {
	public int[] solution(int[] arr) {

		if (arr.length == 1) {
			return new int[] { -1 };
		}
		int[] answer = new int[arr.length - 1];
		int minValue = Integer.MAX_VALUE;
		for (int value : arr) {
			if (minValue > value) {
				minValue = value;
			}
		}
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == minValue) {
				continue;
			}
			answer[idx++] = arr[i];
		}
		return answer;
	}
}
